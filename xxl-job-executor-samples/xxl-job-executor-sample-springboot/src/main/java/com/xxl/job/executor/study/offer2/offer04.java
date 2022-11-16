package com.xxl.job.executor.study.offer2;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-07-19 18:15
 * @description：
 */
public class offer04 {

    public static void main(String[] args) {
        int[][] arrays = {{1,2,3,4,5},{6,7,8,9,10}};
        System.out.println(findNumberIn2DArraySecond(arrays,6));
    }
    //第一种方法是采用二分+暴力算法题解
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

    //从二维矩阵的左下角开始进行对比
    public static boolean findNumberIn2DArraySecond(int[][] matrix, int target) {
        int index = matrix.length - 1;
        int row = 0;
        while (index>0 && row<matrix[0].length){
            if(matrix[index][row] == target){
                return true;
            }else if(matrix[index][row] <target){
                index -- ;
            }else {
                row++;
            }
        }
        return false;
    }

}
