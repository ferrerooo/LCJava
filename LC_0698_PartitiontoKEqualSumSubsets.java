import java.util.*;

public class LC_0698_PartitiontoKEqualSumSubsets {

    private Set<Integer> failures = new HashSet<>();

    public boolean canPartitionKSubsets(int[] nums, int k) {

        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        int sum = 0;
        
        for (int i:nums)
            sum += i;
        
        if (sum%k != 0)
            return false;
        
        int target = sum/k;
        System.out.println(target);
        return canPartition(nums, 0, 0, visited, k, target);
        
    }

    private boolean canPartition(int[] nums, int curSum, int listCount, boolean[] visited, int k, int target) {

        if (listCount == k-1) {
            if (curSum == target) {
                return true;
            }
        } 

        if (curSum > target) {
            return false;
        }

        if (listCount > k)
            return false;

        if (listCount == k) {
            return isAllVisited(visited);
        }

        if (curSum == target) {
            if(canPartition(nums, 0, listCount+1, visited, k, target)) {
                return true;
            } else {
                failures.add(getKey(visited));
                return false;
            }
        }

        for (int i=0; i<nums.length; i++) {

            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            if (failures.contains(getKey(visited))) {
                visited[i] = false;
                continue;
            }

            if (canPartition(nums, curSum+nums[i], listCount, visited, k, target)) {
                return true;
            } else {
                failures.add(getKey(visited));
                visited[i] = false;
            }
        }

        return false;
    }

    private int getKey(boolean[] visited) {
        
        int res = 0;
        for (int i=0; i<visited.length; i++) {

            if (visited[i]) {
                res = res | (1<<i);
            }
        }

        return res;
    }

    private boolean isAllVisited(boolean[] visited) {
        for (boolean v:visited) {
            if (v == false)
                return false;
        }
        return true;
    }
}