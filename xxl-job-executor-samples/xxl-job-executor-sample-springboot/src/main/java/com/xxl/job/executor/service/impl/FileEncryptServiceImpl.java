package com.xxl.job.executor.service.impl;

import com.xxl.job.executor.service.FileEncryptService;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.SecureRandom;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-08-18 16:06
 * @description：文件加解密服务
 */
public class FileEncryptServiceImpl implements FileEncryptService {

    protected static Key key = getKey("wxf");
    /**
     * 根据参数生成KEY
     */
    public static Key getKey(String strKey) {
        try {
            KeyGenerator _generator = KeyGenerator.getInstance("DES");
            _generator.init(new SecureRandom(strKey.getBytes()));
            return _generator.generateKey();
        } catch (Exception e) {
            throw new RuntimeException("Error initializing SqlMap class. Cause: " + e);
        }
    }

    @Override
    public void encrypt(String source, String dest, String soutceType) {
        try {
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            InputStream is = new FileInputStream(source);
            OutputStream out = new FileOutputStream(dest);
            CipherInputStream cis = new CipherInputStream(is, cipher);
            byte[] buffer = new byte[1024];
            int r;
            while ((r = cis.read(buffer)) > 0) {
                out.write(buffer, 0, r);
            }
            cis.close();
            is.close();
            out.close();
        }catch (Exception e){

        }
    }

    @Override
    public void decrypt(String source, String dest, String soutceType) {
        try {
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            InputStream is = new FileInputStream(source);
            OutputStream out = new FileOutputStream(dest);
            CipherOutputStream cos = new CipherOutputStream(out, cipher);
            byte[] buffer = new byte[1024];
            int r;
            while ((r = is.read(buffer)) >= 0) {
                System.out.println();
                cos.write(buffer, 0, r);
            }
            cos.close();
            out.close();
            is.close();
        }catch (Exception e){

        }
    }
}
