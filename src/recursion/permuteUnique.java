package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//去重后的全排列
public class permuteUnique {
    List<List<Integer>> ans;
    int[] nums;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        this.ans = ans;
        this.nums = nums;
        permuteUnique(0);
        return ans;
    }

    public void permuteUnique(int i) {
        if (i == nums.length) {
            //收集
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            ans.add(list);
        } else {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                if (!set.contains(nums[j])) {
                    set.add(nums[j]);
                    swap(nums, i, j);
                    permuteUnique(i + 1);
                    swap(nums, i, j);
                }
            }
        }
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
