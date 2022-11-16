package com.xxl.job.executor.study.offer2;

import org.apache.tomcat.util.digester.ArrayStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-11-16 10:42
 * @description：全排列
 */
public class offerPermute {

    public static void main(String[] args) {
        int[] ints = new int[]{1,2,3,4};
        System.out.println(permute(ints));
    }

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        backtrack(res, nums, new ArrayList<Integer>(), visited);
        return res;

    }

    private static void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, int[] visited) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;
            visited[i] = 1;
            tmp.add(nums[i]);
            backtrack(res, nums, tmp, visited);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }
}
