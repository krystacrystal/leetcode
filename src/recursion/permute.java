package recursion;

import java.util.ArrayList;
import java.util.List;

public class permute {
    List<List<Integer>> ans;
    int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        this.ans = ans;
        this.nums = nums;
        permute(0);
        return ans;
    }

    public void permute(int i) {
        if (i == nums.length) {
            //收集
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            ans.add(list);
        } else {
            for (int j = i; j < nums.length; j++) {
                swap(nums, i, j);
                permute(i + 1);
                swap(nums, i, j);
            }
        }
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
