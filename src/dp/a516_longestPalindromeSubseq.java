package dp;

import java.util.Arrays;

public class a516_longestPalindromeSubseq {

    char[] str;
    int[][] dp;

    //记忆化搜索,区间dp
    public int longestPalindromeSubseq(String s) {
        char[] str = s.toCharArray();
        int[][] dp = new int[str.length][str.length];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        this.dp = dp;
        this.str = str;
        return longestPalindromeSubseq(0, str.length - 1);
    }

    public int longestPalindromeSubseq(int i, int j) {
        //basecase
        if (i == j) {
            return 1;
        }
        if (i + 1 == j) {
            return str[i] == str[j] ? 2 : 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = 0;
        if (str[i] == str[j]) {
            ans = 2 + longestPalindromeSubseq(i + 1, j - 1);
        } else {
            ans = Math.max(longestPalindromeSubseq(i, j - 1), longestPalindromeSubseq(i + 1, j));
        }
        dp[i][j] = ans;
        return ans;
    }

    //严格位置依赖的DP+空间压缩
    //区间DP
    public int longestPalindromeSubseq1(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        //建表
        int[] dp = new int[n];
        //初始化
        //填表
        for (int i = n - 1, leftDown = 0, backUp = 0; i >= 0; i--) {
            //一上来新的一行，先初始化好两个格子，这两个格子不需要依赖关系
            dp[i] = 1;
            if (i + 1 < n) {
                leftDown = dp[i + 1];
                dp[i + 1] = str[i] == str[i + 1] ? 2 : 1;
            }
            for (int j = i + 2; j < n; j++) {
                backUp = dp[j];
                //此时每个格子依赖左、下、左下
                if (str[i] == str[j]) {
                    dp[j] = 2 + leftDown;
                } else {
                    dp[j] = Math.max(dp[j - 1], dp[j]);
                }
                leftDown = backUp;
            }
        }
        return dp[n - 1];
    }
}