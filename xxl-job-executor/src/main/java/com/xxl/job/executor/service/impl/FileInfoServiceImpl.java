package com.xxl.job.executor.service.impl;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;
import com.xxl.job.executor.common.util.ConstantStatus;
import com.xxl.job.executor.common.util.SftpUploadUtil;
import com.xxl.job.executor.domain.po.FileInfo;
import com.xxl.job.executor.mapper.FileInfoMapper;
import com.xxl.job.executor.service.FileInfoService;
import com.xxl.job.executor.service.OssService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.File;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-08-18 13:47
 * @description：
 */
@Service
public class FileInfoServiceImpl implements FileInfoService {

    public static String OSS_PATH_PRE = "oss/";

    @Resource
    FileInfoMapper fileInfoMapper;
    @Resource
    OssService ossService;

    @Override
    @Transactional
    public String fileTran(Date startDate, Date endDate) {

        List<FileInfo> fileInfoList = fileInfoMapper.selectFileInfoByDate(startDate,endDate);
        for (FileInfo fileInfo : fileInfoList) {
            Future<String> result = null;
            ChannelSftp channelSftp = SftpUploadUtil.sftpConnect();
            try {
                InputStream inputStream = channelSftp.get(fileInfo.getRealPath());
                String objectName = OSS_PATH_PRE+fileInfo.getFileName();
                result = ossService.uploadObject(objectName,inputStream);
            } catch (SftpException e) {
                e.printStackTrace();
            }
            if(!Objects.isNull(result)){
                FileInfo updateDto = new FileInfo();
                updateDto.setSerialsNo(fileInfo.getSerialsNo());
                updateDto.setModifyDate(new Date());
                try {
                    updateDto.setOssPath(result.get());
                }catch (Exception e){
                }
                fileInfoMapper.updateById(updateDto);
            }
        }

        return null;
    }

}
