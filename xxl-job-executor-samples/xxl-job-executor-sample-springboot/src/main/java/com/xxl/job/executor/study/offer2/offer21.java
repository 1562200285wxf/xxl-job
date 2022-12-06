package com.xxl.job.executor.study.offer2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-11-18 17:57
 * @description：左边的奇数，右边的偶数
 */
public class offer21 {
    public static void main(String[] args) {
        List<Integer> al = new ArrayList(){};
        al.add(2);
        al.add(3);
        al.add(1);
        al.add(5);
        al.add(4);
        al.add(6);
        al.add(3);
        removeInt(al);
        System.out.println(al.toString());
    }

    public static int convert(String str,int index){
        if(index>20|| index<0 || str.length()>1000)
            return 0;
        int result = 0;
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if(Character.isLowerCase(aChar)){
                result++;
            }else {
                result = result+index*index;
            }
        }
        if(result>=1000)
            return 1000;
        return result;
    }

    public static List<Integer> removeInt(List<Integer> integers){
        Iterator it = integers.iterator();
        while (it.hasNext()) {
            if((Integer)it.next() %3 ==0)
                it.remove();
        }
        return integers;
    }




}
