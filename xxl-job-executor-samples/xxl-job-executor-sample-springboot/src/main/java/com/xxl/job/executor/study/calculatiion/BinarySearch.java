package com.xxl.job.executor.study.calculatiion;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-07-18 14:33
 * @description：二分查找法
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        int code = 5;
        System.out.println(binarySearch(array,code));
    }

    public static int binarySearch(int[] array,int code){
        int left = 0;
        int right = array.length-1;
        int mid;
        while (left <= right){
            mid = (right + left) / 2;
            if(array[mid] == code){
                return mid+1;
            }else if (array[mid] < code) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
