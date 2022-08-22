package com.xxl.job.executor.common.util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-08-10 11:15
 * @description：base64加解密工具
 */
public class Base64Util {

    final static Base64.Encoder encoder = Base64.getEncoder();
    final static Base64.Decoder decoder = Base64.getDecoder();

    /**
     * 加密
     * @param text
     * @return
     */
    public static String encode(String text) {
        return encoder.encodeToString(text.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 解密
     * @param encodedText
     * @return
     */
    public static String decode(String encodedText) {
        return new String(decoder.decode(encodedText), StandardCharsets.UTF_8);
    }

    public static void main(String[] args) {

        String str = "030810.gzy";

        // 加密
        System.out.println("====  加密后  =====");
        System.out.println(Base64Util.encode(str));

        // 解密
        System.out.println("====  解密后  =====");
        System.out.println(Base64Util.decode(Base64Util.encode(str)));
    }

}
