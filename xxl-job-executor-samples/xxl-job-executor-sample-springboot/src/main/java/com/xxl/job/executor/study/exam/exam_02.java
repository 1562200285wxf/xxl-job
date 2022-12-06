package com.xxl.job.executor.study.exam;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-12-06 15:29
 * @description：组成最大数   先把数组进行降序排列
 */
public class exam_02 {
    public static void main(String[] args) {
        String string = "4589,101,41425,9999";
        String[] strings = string.split(",");
        List<String> list = Arrays.stream(strings).sorted(Collections.reverseOrder()).collect(Collectors.toList());
        StringBuilder result = new StringBuilder();
        for (String s : list) {
            result.append(s);
        }
        System.out.println(result.toString());
    }
}
