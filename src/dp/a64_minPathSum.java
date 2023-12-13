package dp;

public class a64_minPathSum {
    //严格位置依赖的dp
    public int minPathSum(int[][] grid) {
        //准备dp表
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        //初始化
        dp[0][0] = grid[0][0];
        //填第1列
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        //填第1行
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        //填表
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        //返回最终的答案
        return dp[n - 1][m - 1];
    }

    //严格位置依赖的dp+空间压缩
    public int minPathSum1(int[][] grid) {
        //建dp表
        int m = grid[0].length;
        int[] dp = new int[m];
        //初始化
        dp[0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i] = dp[i - 1] + grid[0][i];
        }
        //填表
        for (int i = 1; i < grid.length; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < m; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }
        //返回最终要的值
        return dp[m - 1];
    }
}
