package com.xxl.job.executor.service;

public interface FileEncryptService {

    public void encrypt(String source, String dest,String soutceType);

    public void decrypt(String source, String dest,String soutceType);
}
