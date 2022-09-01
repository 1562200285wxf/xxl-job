package com.xxl.job.executor.study.offer2;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-07-19 18:15
 * @description：查找二维数组中的数字---二分折半查找
 */
public class offer04 {

    public static void main(String[] args) {
        int[][] arrays = {{1,2,3,4,5},{6,7,8,9,10}};
        System.out.println(findNumberIn2DArray(arrays,11));
    }
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int line = 0; line < matrix.length; line++) {
            int[] rowArray = matrix[line];
            int left = 0;
            int right = rowArray.length-1;
            int middle;
            while (left <=  right){
                middle = (left+right)/2;
                if(rowArray[middle] == target){
                    return true;
                }else if(rowArray[middle] < target){
                    left = middle+1;
                }else {
                    right  = middle-1;
                }
            }

        }
        return false;
    }


}
