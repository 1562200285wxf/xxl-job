package com.xxl.job.executor.study.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-12-26 14:36
 * @description：数组拼接
 */
public class exam_08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int lineInt = Integer.valueOf(line);
        List<List<String>> ss = new ArrayList<>();
        StringBuffer result = new StringBuffer();
        int maxLength = 0;
        for (int i = 0; i < lineInt; i++) {
            String str = scanner.nextLine();
            String[] strings = str.split(",");
            List<String> list = Arrays.asList(strings);
            ss.add(list);
            if(list.size()>maxLength)
                maxLength = list.size();
        }
        int sub = 0;
        while (sub<(maxLength/lineInt+1)*lineInt){
            int subx = sub+lineInt;
            for (List<String> s : ss) {
                int right = Math.min(subx,s.size());
                for (int i = sub; i < right; i++) {
                    result.append(s.get(i));
                    result.append(",");
                }
            }
            sub+=lineInt;
        }
        System.out.println(result);
    }
}
