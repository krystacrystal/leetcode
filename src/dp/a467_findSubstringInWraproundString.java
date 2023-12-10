package dp;

public class a467_findSubstringInWraproundString {
    public int findSubstringInWraproundString(String s) {
        int n = s.length();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.charAt(i) - 'a';
        }
        int[] dp = new int[26];
        dp[arr[0]] = 1;
        for (int i = 1, len = 1, cur, pre; i < n; i++) {
            cur = arr[i];
            pre = arr[i - 1];
            if ((cur == 0 && pre == 25) || pre + 1 == cur) {
                len++;
            } else {
                len = 1;
            }
            dp[arr[i]] = Math.max(dp[arr[i]], len);
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += dp[i];
        }
        return ans;
    }
}
