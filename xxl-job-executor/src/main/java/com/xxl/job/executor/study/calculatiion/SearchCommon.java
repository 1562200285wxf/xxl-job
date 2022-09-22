package com.xxl.job.executor.study.calculatiion;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-07-19 11:40
 * @description：排序公共方法
 */
public class SearchCommon {

    public static int swapCount = 0;

    public static void swap(int[] array,int src,int des){
        int middle = array[src];
        array[src] = array[des];
        array[des] = middle;
        swapCount++;
    }

    public static void print(int[] array){
        for (int i : array) {
            System.out.println(i);
        }
        System.out.println("-----------------交换次数:" +swapCount+"----------------");
    }
}
