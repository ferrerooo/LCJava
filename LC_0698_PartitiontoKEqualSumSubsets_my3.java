import java.util.*;

public class LC_0698_PartitiontoKEqualSumSubsets_my3 {
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        Arrays.sort(nums);
        int total = 0;
        for (int i:nums)
            total += i;
        
        if (total % k != 0)
            return false;

        int target = total/k;
        System.out.println("target:"+target);

        boolean[] visited = new boolean[nums.length];
        List<Integer> cur = new ArrayList<>();
        
        return dfs(nums, target, cur, visited);
    }

    private boolean allVisited (boolean[] visited) {
        for (boolean b:visited) {
            if (!b)
                return false;
        }

        return true;
    }

    private int sumOf(List<Integer> cur) {
        int total = 0;
        for (int i:cur)
            total += i;
        
        return total;
    }

    private String genKey(boolean[] visited) {
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

    private Map<String, Boolean> cache = new HashMap<>();

    private boolean dfs(int[] nums, int target, List<Integer> cur, boolean[] visited) {

        if (cache.containsKey(genKey(visited))) {
            return cache.get(genKey(visited));
        }

        if (sumOf(cur) == target) {

            if (allVisited(visited)) {
                return true;
            }

            if (dfs(nums, target, new ArrayList<>(), visited)) {
                return true;
            } else {
                return false;
            }
        }

        if (sumOf(cur) > target) {
            return false;
        }

        for (int i=0; i<nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            cur.add(nums[i]);
            if (dfs(nums, target, cur, visited)) {
                cache.put(genKey(visited), true);
                return true;
            } else {
                cache.put(genKey(visited), false);
            }
            visited[i] = false;
            cur.remove(cur.size()-1);
        }

        return false;
    }


}