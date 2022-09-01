package com.xxl.job.executor.study.offer2;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-07-20 11:37
 * @description：机器人的运动范围
 */
public class offer13 {
    public static void main(String[] args) {
        System.out.println(movingCount(16, 8, 4));
    }
    // 棋盘的行列
    static int m, n;
    // 记录位置是否被遍历过
    static boolean[][] visited;

    public static int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        return dfs(0, 0, k);
    }

    private static int dfs(int i, int j, int k) {
        // i >= m || j >= n是边界条件的判断
        if (i >= m || j >= n
                // visited[i][j]判断这个格子是否被访问过
                || visited[i][j] == true
                // k < sum(i, j)判断当前格子坐标是否满足条件
                || sum(i, j) > k) {
            return 0;
        }
        // 标注这个格子被访问过
        visited[i][j] = true;
        // 沿着当前格子的右边和下边继续访问
        return 1 + dfs(i + 1, j, k)
                + dfs(i, j + 1, k);
    }

    public static int sum(int m, int n){
        int count = 0;
        count = count+m%10;
        while (m/10!=0){
            m = m/10;
            count = count+m%10;
        }
        count = count+n%10;
        while (n/10!=0){
            n = n/10;
            count = count+n%10;
        }
        return count;
    }
}
