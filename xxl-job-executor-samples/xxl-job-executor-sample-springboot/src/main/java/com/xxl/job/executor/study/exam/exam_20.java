package com.xxl.job.executor.study.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-12-27 14:54
 * @description：滑动窗口最大值
 */
public class exam_20 {
    public static void main(String[] args) {

        int[] ints = new int[]{9,10,9,-7,-4,-8,2,-6};
        int[] result = maxSlidingWindow(ints,5);
        System.out.println(maxSlidingWindow(ints,5));

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int max = nums[0];
        int index = 0;
        for (int i = 1; i < k; i++) {
            if(nums[i]>=max){
                max = nums[i];
                index = i;
            }
        }
        list.add(max);
        for (int right = k; right < nums.length; right++) {
            if(index!=right-k){
                if(nums[right]>max){
                    max = nums[right];
                    index = right;
                }
            }
            else {
                index = right-k+1;
                max = nums[index];
                for (int j = right-k+2; j < right+1; j++) {
                    if(nums[j]>max){
                        max = nums[j];
                        index = j;
                    }
                }
            }
            list.add(max);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
