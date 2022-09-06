package com.xxl.job.executor.study.oppo;

import org.apache.catalina.mapper.Mapper;

import java.util.*;
import java.util.logging.Handler;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-09-03 11:23
 * @description：
 */
public class Main {


    public static void main(String[] args) {
        int[] ints = new int[10];
        System.out.println(ints.length);
        System.out.println(ints[0]);
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        String str1 = sc.nextLine();
//        String str2 = sc.nextLine();
//        int[] ints = Arrays.stream(str1.split(" ")).mapToInt(Integer::parseInt).toArray();
//        String[] strings = str2.split("");
//        for (int index = 2; index <= Integer.valueOf(str); index++) {
//            ttt(ints,index,strings);
//        }
//        for (Integer integer : map.keySet()) {
//            System.out.print(map.get(integer).size());
//        }
//        System.out.println(new Integer(1) == new Integer(1));

//        new B();
    }

    public static Map<Integer, Set<String>> map = new HashMap<>();

    protected    void ttt(int[] ints,int index,String[] strings){
        int init = 0;
        while (init<ints.length){
            if(ints[init] == index){
                ttt(ints,init+2,strings);
                if(map.containsKey(index)){
                    map.get(index).add(strings[index]);
                }else {
                    Set<String> set = new HashSet<>();
                    set.add(strings[index]);
                    map.put(index,set);
                }
            }
            init++;
        }
    }



}
