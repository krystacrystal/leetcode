package dp;

public class a97_isInterleave {

    //string1和String2是否能交错组成String3
    //动态规划+空间压缩
    public boolean isInterleave(String string1, String string2, String string3) {
        if (string1.length() + string2.length() != string3.length()) {
            return false;
        }
        char[] s1 = string1.toCharArray();
        char[] s2 = string2.toCharArray();
        char[] s3 = string3.toCharArray();
        int n = s1.length;
        int m = s2.length;
        boolean[] dp = new boolean[m + 1];
        //初始化
        dp[0] = true;
        for (int j = 1; j <= m; j++) {
            if (s2[j - 1] != s3[j - 1]) {
                break;
            }
            dp[j] = true;
        }
        //填表
        for (int i = 1; i <= n; i++) {
            dp[0] = s1[i - 1] == s3[i - 1] && dp[0];
            for (int j = 1; j <= m; j++) {
                if ((s1[i - 1] == s3[i + j - 1] && dp[j]) ||
                        (s2[j - 1] == s3[i + j - 1] && dp[j - 1])) {
                    dp[j] = true;
                } else {
                    dp[j] = false;
                }
            }
        }
        //返回最终值
        return dp[m];
    }

}
