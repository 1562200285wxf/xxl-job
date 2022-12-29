package com.xxl.job.executor.study.exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-12-29 17:42
 * @description：两数之和最小
 */
public class exam_002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        int[]ints = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
        int left = 0;
        int right = ints.length-1;
        int result = ints[left]+ints[right];
        while (left<right){
            int temp =ints[left]+ints[right];
            result = Math.min(ab(temp),ab(result));
            if((ints[left+1]-ints[left])>ints[right]+ints[right-1]){
                left++;
            }else {
                right--;
            }
        }
        System.out.println(result);
    }

    private static int ab(int a) {
        if(a<0){
            return -a;
        }else return a;
    }


}
