package com.xxl.job.executor.study.exam;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-12-06 18:32
 * @description：判断是不是子字符串
 */
public class exam_04 {
    public static void main(String[] args) {


        String str1 = "ahbgdc";
        String str2 = "abc";
        String[] strings2 = str2.split("");

        int index = 0;
        int length = strings2.length;
        for (int i = 0; i < length; i++) {
            int target = str1.indexOf(strings2[i],index);
            if(target != -1){
                if(index==length-1){
                    System.out.println("true");
                    return;
                }
                index++;
            }else {
                System.out.println("false");
                return;
            }
        }


    }



}
