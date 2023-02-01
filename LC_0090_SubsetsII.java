import java.util.*;

public class LC_0090_SubsetsII {
    
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        int index = 0;

        this.dfs(nums, res, cur, index);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> cur, int index) {
        
        res.add(new ArrayList<Integer>(cur));

        if (index == nums.length) {
            return;
        }

        for (int i=index; i<nums.length; i++) {

            if (i > index && nums[i] == nums[i-1]) {
                continue;
            }
            
            cur.add(nums[i]);
            this.dfs(nums, res, cur, i+1);
            cur.remove(cur.size()-1);
        }

    }
}
