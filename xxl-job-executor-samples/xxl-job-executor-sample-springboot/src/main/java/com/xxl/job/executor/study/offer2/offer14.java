package com.xxl.job.executor.study.offer2;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-07-28 16:15
 * @description：减绳子
 */
public class offer14 {

    public static void main(String[] args) {
        System.out.println(cuttingRope(3));
    }
    public static int cuttingRope(int n) {
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int middle = i*sum(n-i);
            if(middle>max){
                max = middle;
            }
        }
        return max;
    }

    //先找拆分为两个数，求最大值。
    public static int sum(int m){
        int result = (m-(m/2))*(m/2);
        return (m-(m/2))*(m/2);
    }
    public static int cuttingRope1(int n) {
        /*
        dp五部曲:
        1.状态定义:dp[i]为长度为i的绳子剪成m段最大乘积为dp[i]
        2.状态转移:dp[i]有两种途径可以转移得到
            2.1 由前一个dp[j]*(i-j)得到,即前面剪了>=2段,后面再剪一段,此时的乘积个数>=3个---选择第一种
            2.2 前面单独成一段,后面剩下的单独成一段,乘积为j*(i-j),乘积个数为2
            两种情况中取大的值作为dp[i]的值,同时应该遍历所有j,j∈[1,i-1],取最大值
        3.初始化:初始化dp[1]=1即可
        4.遍历顺序:显然为正序遍历
        5.返回坐标:返回dp[n]
        */
        // 定义dp数组
        int[] dp = new int[n + 1];
        // 初始化
        dp[1] = 1;  // 指长度为1的单独乘积为1
        // 遍历[2,n]的每个状态
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i - 1; j++) {
                // 求出两种转移情况(乘积个数为2和2以上)的最大值
                int tmp = Math.max(dp[j] * (i - j), j * (i - j));
                dp[i] = Math.max(tmp, dp[i]);
            }
        }
        return dp[n];
    }

    /*---主要关心长度和次数
    * 由于题目限制至少剪 1 次，直接写递推关系不易得出，故将其分为两步求解：
    利用动态规划得到不限制至少剪 1 次的最大乘积，递推关系：dp[i] = Math.max(dp[i], j * dp[i - j]);
    再手动剪一次，计算至少剪一次条件下最大乘积
    * */
    public int cuttingRope2(int n) {
        // dp[i] 表示长度为 i 的绳子最大乘积（可以不剪即只有 1 段）
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], j * dp[i - j]);
            }
        }

        // 手动剪一次，计算至少剪一次条件下最大乘积
        int ans = 1;
        for (int i = 1; i < n; i++) {
            ans = Math.max(i * dp[n - i], ans);
        }
        return ans;
    }


}
