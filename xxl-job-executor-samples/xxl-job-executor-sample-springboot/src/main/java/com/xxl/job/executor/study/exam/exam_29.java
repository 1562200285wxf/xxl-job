package com.xxl.job.executor.study.exam;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-12-28 10:06
 * @description：
 */
public class exam_29 {

    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{16,15});
        list.add(new int[]{16, 14});
        list.add(new int[]{13, 12});
        list.add(new int[]{15, 14});
        list = list.stream().sorted((a,b)->{
            if(a[0]!=b[0]){
                return a[0]-b[0];
            }else {
                return a[1]-b[1];
            }
        }).collect(Collectors.toList());

        int result = 1;
        int[] origin = list.get(0);
        for (int[] ints : list) {
            if(ints[0]>origin[0] && ints[1]>origin[1]){
                result++;
                origin = ints;
            }else continue;
        }
        System.out.println(result);
    }


}
