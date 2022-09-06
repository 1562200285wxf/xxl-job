package com.xxl.job.executor.study.bank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-09-05 19:46
 * @description：
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String str3 = sc.nextLine();
        int k = Integer.valueOf(str3);
        int length = Integer.valueOf(str1);
        int[] array = Arrays.asList(str2.split(" ")).stream().mapToInt(Integer::parseInt).toArray();

        int[] result = new int[length-k+1];
        for (int i = 0; i <= length-k; i++) {
            int[] copyArr = Arrays.copyOfRange(array,i,i+k);
            result[i] = finMax(copyArr);
        }
        System.out.println(Arrays.toString(result));

    }


    public static int finMax(int[] ints){
        //排序，找中位数
        Arrays.sort(ints);
        double half= 0;
        if (ints.length % 2 == 0) {
            half = (double) ((ints[ints.length / 2 - 1] + ints[ints.length / 2])) / 2;
        }else {
            half = (double)ints[ints.length / 2];
        }
        double max = 0;
        int index = 0;
        for (int i = 0; i < ints.length; i++) {
            double middle = (double)(half>ints[i]?half-ints[i]:ints[i]-half);
            if(Double.doubleToLongBits(middle) >Double.doubleToLongBits(max) || (Double.doubleToLongBits(middle)==Double.doubleToLongBits(max) && ints[index]<ints[i])){
                max = middle;
                index = i;
            }
        }

        return ints[index];
    }
}
