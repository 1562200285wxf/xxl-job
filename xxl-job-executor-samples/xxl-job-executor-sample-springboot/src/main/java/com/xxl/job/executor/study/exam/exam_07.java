package com.xxl.job.executor.study.exam;

import java.util.List;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-12-07 15:44
 * @description：跟节点到最小节点的路径
 */
public class exam_07 {
    public static void main(String[] args) {

    }
    public static List<Integer> solution(List<String> list,int target,int length){
        int l = length+1;
        int[][] ints = new int[l][l];
        for (int i = 1; i < l; i++) {
            for (int j = 1; j < l; j++) {
                if(i == j)continue;
                int sum = Integer.valueOf(list.get(i))-Integer.valueOf(list.get(j));
                String str = String.valueOf("-"+2*sum);
                if(list.contains(str)){
                    System.out.println();
                }
            }
        }
        return null;
    }
}
