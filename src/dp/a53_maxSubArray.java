package dp;

public class a53_maxSubArray {

    //动态规划+空间压缩
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int pre = nums[0];
        int ans = pre;
        for (int i = 1; i < n; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            ans = Math.max(pre, ans);

        }
        return pre;
    }

}
