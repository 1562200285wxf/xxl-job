package com.xxl.job.executor.study.bishi;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test11 {
    public static void main(String[] args) {
        System.out.println("xuqi");
        Scanner in = new Scanner(System.in);
        String[] a = in.nextLine().split("、");
        int[] arr = Arrays.asList(a).stream().mapToInt(Integer::parseInt).toArray();
        Set<String> result = new HashSet<>();
        for (int first = 0; first < arr.length; first++) {
            for (int second = 1; second < arr.length; second++) {
                for (int third = 2; third < arr.length; third++) {
                    String num = String.valueOf(arr[first])+String.valueOf(arr[second])+String.valueOf(arr[third]);
                    result.add(num);
                }
            }
        }
        System.out.println("总数："+result.size());
        System.out.println("无重复组合:"+result);
    }
}
