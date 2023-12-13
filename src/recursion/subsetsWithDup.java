package recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//数组的所有组合
public class subsetsWithDup {
    List<List<Integer>> ans;
    int[] path;
    int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int[] path = new int[nums.length];
        this.ans = ans;
        this.path = path;
        this.nums = nums;
        subsetsWithDup(0, 0);
        return ans;
    }

    //size表示当前path中已经填了多少个字符
    //size也就是之前做的决策中已经有了多少个字符
    public void subsetsWithDup(int i, int size) {
        if (i == nums.length) {
            //收集路径
            //数组转换为列表list
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                list.add(path[j]);
            }
            ans.add(list);
        } else {
            int j = i;
            while (j < nums.length && nums[j] == nums[i]) {
                j++;
            }
            //要0个
            subsetsWithDup(j, size);
            for (; i < j; i++) {
                path[size++] = nums[i];
                subsetsWithDup(j, size);
            }
        }
    }

    @Test
    public void test() {
        List<List<Integer>> lists = subsetsWithDup(new int[]{1, 1, 1, 2, 2, 3, 3, 3});
        for (List<Integer> list : lists) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
