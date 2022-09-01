package com.xxl.job.executor.study.calculatiion;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-07-18 15:39
 * @description：冒泡排序
 */
public class BubbleSearch {

    public static void main(String[] args) {
        int[] array = {1,5,3,7,9,2};
        SearchCommon.print(bubbleSortOpt(array));
    }

    /*
    * 在进行优化的时候只需要考虑跳出当前循环即可
    * */
    public static int[] bubbleSort(int[] array){
        for (int line = 0; line <array.length; line++) {
            for (int row = line+1; row <array.length ; row++) {
                if(array[line]>array[row]){
                    SearchCommon.swap(array,line,row);
                }
            }
        }
        return array;
    }

    /*
    * 排序从小数组开始
    * 每一次最大的留在后面
    * */
    public static int[] bubbleSortOpt(int[] array){
        boolean flag = true;
        for (int line = 0; line <array.length; line++) {
            if(flag == false){
                break;
            }
            flag = false;
            for (int row = 0; row <array.length-1-line ; row++) {
                if(array[row]>array[row+1]){
                    flag = true;
                    SearchCommon.swap(array,row+1,row);
                }
            }
        }
        return array;
    }


}
