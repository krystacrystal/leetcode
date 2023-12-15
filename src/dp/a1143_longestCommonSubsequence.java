package dp;

public class a1143_longestCommonSubsequence {
    char[] s1;
    char[] s2;
    int[][] dp;

    //记忆化搜索
    public int longestCommonSubsequence(String text1, String text2) {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        int[][] dp = new int[s1.length + 1][s2.length + 1];
        for (int i = 0; i <= s1.length; i++) {
            for (int j = 0; j <= s2.length; j++) {
                dp[i][j] = -1;
            }
        }
        this.s1 = s1;
        this.s2 = s2;
        this.dp = dp;
        return longestCommonSubsequence(s1.length, s2.length);
    }

    //i1:s1的前缀长度,i2:s2的前缀长度
    public int longestCommonSubsequence(int i1, int i2) {
        //base case
        if (i1 == 0 || i2 == 0) {
            return 0;
        }
        if (dp[i1][i2] != -1) {
            return dp[i1][i2];
        }
        //决策
        int ans = 0;
        if (s1[i1 - 1] == s2[i2 - 1]) {
            ans = longestCommonSubsequence(i1 - 1, i2 - 1) + 1;
        } else {
            ans = Math.max(longestCommonSubsequence(i1, i2 - 1), longestCommonSubsequence(i1 - 1, i2));
        }
        dp[i1][i2] = ans;
        return ans;
    }

    //严格位置依赖的dp
    public int longestCommonSubsequence1(String text1, String text2) {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        int m = s1.length;
        int n = s2.length;
        //建表
        int[][] dp = new int[m + 1][n + 1];
        //初始化
        //填表-分析位置依赖
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }

    //严格位置依赖的dp+空间压缩
    public int longestCommonSubsequence2(String text1, String text2) {
        char[] s1;
        char[] s2;
        if (text1.length() >= text2.length()) {
            s1 = text1.toCharArray();
            s2 = text2.toCharArray();
        } else {
            s1 = text2.toCharArray();
            s2 = text1.toCharArray();
        }
        int m = s1.length;
        int n = s2.length;
        //建表
        int[] dp = new int[n + 1];
        //初始化
        //填表-分析位置依赖
        for (int i = 1; i <= m; i++) {
            int leftUp = 0, backUp;//backUp是备份变量
            for (int j = 1; j <= n; j++) {
                backUp = dp[j];
                if (s1[i - 1] == s2[j - 1]) {
                    dp[j] = leftUp + 1;
                } else {
                    dp[j] = Math.max(dp[j - 1], dp[j]);
                }
                leftUp = backUp;
            }
        }
        return dp[n];
    }

}
