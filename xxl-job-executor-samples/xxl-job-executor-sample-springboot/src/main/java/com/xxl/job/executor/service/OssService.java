package com.xxl.job.executor.service;

import java.io.File;
import java.io.InputStream;
import java.util.Map;

public interface OssService {

    public void cacheOssList();

    public void refreshCache();

    public String getDownUrl(String KeyName);

    /*
    * 上传文件并返回下载链接
    * */
    public String uploadObject(String objectName, File file);
}
