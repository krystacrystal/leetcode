package dp;

public class a115_numDistinct {

    //动态规划
    public int numDistinct(String s1, String t1) {
        char[] s = s1.toCharArray();
        char[] t = t1.toCharArray();
        int n = s.length;
        int m = t.length;
        //建表
        int[][] dp = new int[n + 1][m + 1];
        //初始化
        for (int j = 0; j <= n; j++) {
            dp[j][0] = 1;
        }
        //填表
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (s[i - 1] == t[j - 1]) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        //返回最终的值
        return dp[n][m];
    }

    //动态规划+空间压缩
    public int numDistinct1(String s1, String t1) {
        char[] s = s1.toCharArray();
        char[] t = t1.toCharArray();
        int n = s.length;
        int m = t.length;
        //建表
        int[] dp = new int[m + 1];
        //初始化
        dp[0] = 1;
        //填表
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 1; j--) {
                if (s[i - 1] == t[j - 1]) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        //返回最终的值
        return dp[m];
    }

}
