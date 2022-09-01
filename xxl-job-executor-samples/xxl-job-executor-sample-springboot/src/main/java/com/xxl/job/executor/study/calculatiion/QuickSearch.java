package com.xxl.job.executor.study.calculatiion;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-07-19 11:34
 * @description：快速排序
 */
public class QuickSearch {

    public static void main(String[] args) {
        int[] array = {1,4,7,9,3,6};
        quickSort(array,0,5);
        SearchCommon.print(array);
    }


    public static void quickSort(int[] array,int low,int high){
        int start = low;
        int end = high;
        int middle = array[low];
        while (start<end){
            while (start<end && array[end]>middle){
                end--;
            }
            if(array[end]<middle){
                SearchCommon.swap(array,end,start);
            }
            while(end>start&&array[start]<=middle)
                start++;
            if(array[start]>=middle){
                SearchCommon.swap(array,end,start);
            }
            //递归
            if(start>low) quickSort(array,low,start-1);//左边序列。第一个索引位置到关键值索引-1
            if(end<high) quickSort(array,end+1,high);//右边序列。从关键值索引+1 到最后一个
        }
    }
}
