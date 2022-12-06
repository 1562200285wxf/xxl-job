package com.xxl.job.executor.study.exam;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-12-06 15:58
 * @description：
 */
public class exam_03 {
    public static void main(String[] args) {
        String indexs = "3,3,7,4,4,4,4,7,7,3,5,5,5";
        String scores = "53,80,68,24,39,76,66,16,100,55,53,80,55";
        String[] indexArray = indexs.split(",");
        String[] scoreArray = scores.split(",");
        int n =indexArray.length;
        Map<String , List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String key = indexArray[i];
            if(map.containsKey(key)){
                add(map.get(key),scoreArray[i]);
            }else {
                List<String> list = new ArrayList<>();
                list.add(scoreArray[i]);
                map.put(key,list);
            }
        }
        LinkedHashMap<String,Integer> map1 = new LinkedHashMap<>();
        for (String key : map.keySet()) {
            if(map.get(key).size()==3){
                map1.put(key,sum(map.get(key)));
            }
        }
      List<String> list = map1.entrySet().stream()
              .sorted((a,b)->b.getValue()-a.getValue())
              .map(a->a.getKey()).collect(Collectors.toList());

        System.out.println(list.toString());
    }


    protected static void add(List<String> list,String str){
        if(list.size() <3){
            list.add(str);
        }else {
            int index = 0;
            int value = Integer.valueOf(list.get(0));
            int value02 = Integer.valueOf(list.get(1));
            int value03 = Integer.valueOf(list.get(2));
            if(value>value02){
                value=value02;
                index = 1;
            }
            if(value>value03){
                index = 2;
            }
            list.set(index,str);
        }
    }

    protected static Integer sum(List<String> list){
        Integer integer =0;
        for (String str : list) {
            integer+=Integer.valueOf(str);
        }
        return integer;
    }
}
