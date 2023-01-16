import java.util.*;

public class LC_0698_PartitiontoKEqualSumSubsets_2ndTry {
    int count = 0;
    Set<String> failure = new HashSet<>();
    public boolean canPartitionKSubsets(int[] nums, int k) {

        Arrays.sort(nums);
        int sum = 0;
        for (int i:nums)
            sum += i;
        
        if (sum % k != 0)
            return false;
        
        int target = sum / k;
        boolean[] visited = new boolean[nums.length];
        return this.dfs(nums, k, target, visited, new ArrayList<Integer>());
        
    }

    private boolean dfs(int[] nums, int k, int target, boolean[] visited, List<Integer> cur) {

        if (sumOf(cur) > target) {
            return false;
        }

        if (failure.contains(genStr(visited)))
            return false;

        if (sumOf(cur) == target) {            
            count++;
            if (count == k) {
                if (allVisited(visited)) {
                    return true;
                } else {
                    count--;
                    failure.add(genStr(visited));
                    return false;
                }
            }

            if (dfs(nums, k, target, visited, new ArrayList<Integer>())) {
                return true;
            } else {
                count --;
            }
        }

        for (int i=0; i<nums.length; i++) {

            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            cur.add(nums[i]);
            if (this.dfs(nums, k, target, visited, cur))
                return true;
            else {
                visited[i] = false;
                cur.remove(cur.size()-1);
            }
        }

        failure.add(genStr(visited));
        return false;
    }

    private String genStr(boolean[] visited) {
        StringBuilder sb = new StringBuilder();
        for (boolean b : visited) {
            if (b) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }

        return sb.toString();
    }

    private int sumOf(List<Integer> list) {
        int sum = 0;
        for (int i : list)
            sum += i;
        
        return sum;
    }

    private boolean allVisited(boolean[] visited) {
        for (boolean b:visited) {
            if (!b)
                return false;
        }
        return true;
    }
}