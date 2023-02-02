import java.util.*;

public class LC_0377_CombinationSumIV_dfsTimeOut {
    
    private int res = 0;

    public int combinationSum4(int[] nums, int target) {
        
        List<Integer> cur = new ArrayList<>();
        int sum = 0;

        dfs(nums, target, cur, sum);
        return res;
    }

    private void dfs(int[] nums, int target, List<Integer> cur, int sum) {

        if (sum == target) {
            res++;
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i=0; i<nums.length; i++) {

            cur.add(nums[i]);
            dfs(nums, target, cur, sum+nums[i]);
            cur.remove(cur.size()-1);

        }

    }
}