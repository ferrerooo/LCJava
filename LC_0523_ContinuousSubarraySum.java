import java.util.*;

public class LC_0523_ContinuousSubarraySum {
    
    public boolean checkSubarraySum(int[] nums, int k) {
        
        int[] prefixSum = new int[nums.length+1];
        prefixSum[0] = 0;
        for (int i=1; i<=nums.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i-1];
        }

        // key - prefixSum[i]%k
        // val - prefixSum index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i]%k;
            if (map.containsKey(prefixSum[i])) {
                if (i - map.get(prefixSum[i]) > 1)
                    return true;
            } else {
                map.put(prefixSum[i], i);
            }
        }
        
        return false;
    }
}