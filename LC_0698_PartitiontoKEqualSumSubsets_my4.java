import java.util.*;

public class LC_0698_PartitiontoKEqualSumSubsets_my4 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        int total = 0;
        for (int i:nums) {
            total += i;
        }

        if (total % k != 0) {
            return false;
        }

        int target = total/k;

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        return dfs(nums, k, target, visited, cur, res);
    }

    private int getSum(List<Integer> cur) {
        int ans = 0;
        for (int i:cur) {
            ans +=i;
        }

        return ans;
    }

    private boolean isAllVisited (boolean[] visited) {
        for (boolean b:visited) {
            if (!b)
                return false;
        }

        return true;
    }

    private Set<String> failedSet = new HashSet<>();

    private String getKey(boolean[] visited) {
        StringBuilder sb = new StringBuilder();
        for (boolean b:visited) {
            if (b) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }
        return sb.toString();
    }

    private boolean dfs(int[] nums, int k, int target, boolean[] visited, List<Integer> cur, List<List<Integer>> res) {

        if (failedSet.contains(getKey(visited))) {
            return false;
        }

        int curSum = getSum(cur);

        if (curSum > target){
            return false;
        }
        
        if (curSum == target) {

            res.add(new ArrayList<>(cur));
            cur = new ArrayList<>();

            if (isAllVisited(visited)) {
                return true;
            }
        }

        for (int i=0; i<nums.length; i++) {

            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            cur.add(nums[i]);

            if (dfs(nums, k, target, visited, cur, res)) {
                return true;
            }

            failedSet.add(getKey(visited));

            visited[i] = false;
            cur.remove(cur.size()-1);
        }

        return false;

    }
}