package com.xxl.job.executor.study.exam;

import java.util.Scanner;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-12-29 17:06
 * @description：分苹果   忘记进位，最后的异或操作必然相等
 */
public class exam_001 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        int totalSum = 0;
        int bSum = 0;
        int a =  10000;
        for (int i = 0; i < strings.length ; i++) {
            int num = Integer.valueOf(strings[i]);
            bSum = bSum^num;
            totalSum +=totalSum;
            a = Math.min(a,num);
        }
        if(0!=bSum){
            System.out.println(-1);
        }else{
            System.out.println(totalSum-a);
        }
    }


}
