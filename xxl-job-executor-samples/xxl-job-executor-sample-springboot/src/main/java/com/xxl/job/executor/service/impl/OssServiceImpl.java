package com.xxl.job.executor.service.impl;

import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.aliyun.oss.model.PutObjectRequest;
import com.xxl.job.executor.common.util.Base64Util;
import com.xxl.job.executor.common.util.ConstantStatus;
import com.xxl.job.executor.service.OssService;
import org.springframework.context.annotation.Conditional;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-08-18 16:19
 * @description：
 */
@Service
public class OssServiceImpl implements OssService {
    static OSS ossClient ;
    private static String endPoint = "https://oss-cn-hangzhou.aliyuncs.com";
    private static String accessKeyId = Base64Util.decode("TFRBSTV0UVpFUWZtcjE2dkNQdlk5TEpn");
    private static String accessKeySecret = Base64Util.decode("b3NYTHozYlB6UTF1MUphMVczYUs3OG9FTm1BaDAw");;
    private static String bucketName = "telegram01";

    private static Map<String,String> cacheMap = new HashMap<>();
    private static int effectiveTime = 36000;


    @Override
    public void cacheOssList() {
        ObjectListing objectListing = ossClient.listObjects(bucketName);

        Date expiration = new Date(new Date().getTime() + effectiveTime);
        for (OSSObjectSummary objectSummary : objectListing.getObjectSummaries()) {
            String keyName = objectSummary.getKey();
            GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucketName, keyName, HttpMethod.GET);
            request.setExpiration(expiration);
            String url = ossClient.generatePresignedUrl(request).toString();
            cacheMap.put(keyName,url);
        }
        ossClient.shutdown();
    }

    @Override
    public void refreshCache() {
        cacheOssList();
    }

    @Override
    public String getDownUrl(String KeyName) {
        if(cacheMap.containsKey(KeyName)){
            return cacheMap.get(KeyName);
        }else {
            OSS ossClient = new OSSClientBuilder().build(endPoint,accessKeyId,accessKeySecret);
            GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucketName, KeyName, HttpMethod.GET);
            Date expiration = new Date(new Date().getTime() + effectiveTime);
            request.setExpiration(expiration);
            String url = ossClient.generatePresignedUrl(request).toString();
            return url;
        }
    }


    @Override
    public String uploadObject(String objectName, File file) {
        Map<String,String> stringMap = new HashMap<>();
        try {
            OSS ossClient = new OSSClientBuilder().build(endPoint,accessKeyId,accessKeySecret);
            InputStream inputStream = new FileInputStream(file);
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, inputStream);
            ossClient.putObject(putObjectRequest);
            GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucketName, objectName, HttpMethod.GET);
            Date expiration = new Date(new Date().getTime() + effectiveTime);
            request.setExpiration(expiration);
            String url = ossClient.generatePresignedUrl(request).toString();

            stringMap.put(ConstantStatus.UPLOAD_SUCCESS,url);
            return url;
        }catch (OSSException | FileNotFoundException oe){
        }finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return null;
    }

    @Override
    @Async
    public Future<String> uploadObject(String objectName, InputStream inputStream) {
        try {
            System.out.println(Thread.currentThread().getName());
            OSS ossClient = new OSSClientBuilder().build(endPoint,accessKeyId,accessKeySecret);
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, inputStream);
            ossClient.putObject(putObjectRequest);
            GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucketName, objectName, HttpMethod.GET);
            Date expiration = new Date(new Date().getTime() + effectiveTime);
            request.setExpiration(expiration);
            String url = ossClient.generatePresignedUrl(request).toString();
            return new AsyncResult<>(url);
        }catch (OSSException oe){
        }finally {
            try {
                inputStream.close();
            }catch (IOException e){

            }
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return null;
    }


    public static void main(String[] args) throws FileNotFoundException {
        OssServiceImpl ossService = new OssServiceImpl();
        String basePath = "C:\\Users\\15622\\Desktop\\晨钟暮鼓加密.mp4";
        File file = new File(basePath);

    }
}
