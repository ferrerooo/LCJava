import java.util.*;

public class LC_0047_PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        this.dfs(nums, res, cur, visited);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> cur, boolean[] visited) {

        if (cur.size() == nums.length) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }

        for (int i=0; i<nums.length; i++) {

            if (visited[i])
                continue;

            if (i>0 && nums[i] == nums[i-1] && !visited[i-1]) {
                continue;
            }

            visited[i] = true;
            cur.add(nums[i]);
            this.dfs(nums, res, cur, visited);
            visited[i] = false;
            cur.remove(cur.size()-1);
        }

    }
}