package com.xxl.job.executor.study.offer2;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-07-20 11:21
 * @description：替换空格
 */
public class offer05 {
    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
    }
    public static String replaceSpace(String s) {
        StringBuilder result = new StringBuilder();
        char[]  chars = s.toCharArray();
        for (char aChar : chars) {
            if(32 == aChar){
                result.append("%20");
            }else {
                result.append(aChar);
            }
        }
        return result.toString();
    }
}
