package com.xxl.job.executor.study.calculatiion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-08-09 10:02
 * @description：三个数之和为0
 */
public class ThreeSumToZero {

    public static void main(String[] args) {
        int[] ints = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};

    }

    /*
    * 先进行排序
    * */
    public List<List<Integer>> threeSum2(int[] nums) {
        int[] ints = Arrays.stream(nums).sorted().toArray();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if(nums[i]+nums[j]+nums[k] == 0){
                        List<Integer> one = Arrays.asList(nums[i],nums[j],nums[k]);
                        if(!iisContain(result,one)) {
                            result.add(one);
                        }
                    }
                }
            }
        }
        return result;
    }


    public List<List<Integer>> threeSum(int[] ints) {
        int[] nums = Arrays.stream(ints).sorted().toArray();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length-2; i++) {
            int left = i+1;
            int right = nums.length-1;
            while (left<right){
                int target = nums[left]+nums[right]+nums[i];
                if(target>0){
                    right--;
                }else if(target<0){
                    left++;
                }else {
                    List<Integer> one = Arrays.asList(nums[i],nums[left],nums[right]);
                    result.add(one);
                }
            }
        }
        return result;
    }






    static boolean iisContain(List<List<Integer>> listList,List<Integer> list){
        for (List<Integer> integers : listList) {
            if(integers.containsAll(list) && list.containsAll(integers)){
                return true;
            }
        }
        return false;
    }


}
