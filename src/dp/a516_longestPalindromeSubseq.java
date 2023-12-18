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

}
