package nowcoder;

// 测试链接：
// https://www.nowcoder.com/practice/aaefe5896cce4204b276e213e725f3ea

import java.awt.color.CMMException;
import java.io.*;
import java.util.Scanner;

public class NodenHeightNotLargerThanm {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            int n = (int) in.nval;
            in.nextToken();
            int m = (int) in.nval;
            out.println(compute(n, m));
        }
        out.flush();
        out.close();
        br.close();
    }

    public static int MOD = 1000000007;
    public static int MAXN = 51;

    public static long[][] dp = new long[MAXN][MAXN];

    static {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
    }

    //记忆化搜索
    public static int compute(int n, int m) {
        //basecase
        if (n == 0) {
            return 1;
        }
        if (m == 0) {
            return 0;
        }
        if (dp[n][m] != -1) {
            return (int) dp[n][m];
        }
        long ans = 0;
        for (int k = 0; k < n; k++) {
            ans = (ans + ((long) compute(k, m - 1) * compute(n - 1 - k, m - 1)) % MOD) % MOD;
        }
        dp[n][m] = ans;
        return (int) ans;
    }

}
