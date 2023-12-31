package dp;

public class a72_minDistance {

    public int minDistance(String word1, String word2) {
        return minDistance1(word1, word2, 1, 1, 1);
    }

    //插入代价a  删除代价b 替换代价c
    //动态规划+空间压缩
    public int minDistance1(String word1, String word2, int a, int b, int c) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int n = w1.length;
        int m = w2.length;
        //定义dp表
        int[] dp = new int[m + 1];
        //初始化
        for (int i = 1; i <= m; i++) {
            dp[i] = i * a;
        }
        //填表
        for (int i = 1, backUp = 0, leftUp = 0; i <= n; i++) {
            leftUp = (i - 1) * b;
            dp[0] = i * b;
            for (int j = 1; j <= m; j++) {
                backUp = dp[j];
                if (w1[i - 1] == w2[j - 1]) {
                    //依赖左上角的值
                    dp[j] = leftUp;
                } else {
                    dp[j] = Math.min(Math.min(leftUp + c, dp[j - 1] + a), dp[j] + b);
                }
                leftUp = backUp;
            }
        }
        //返回最终的值
        return dp[m];
    }
}
