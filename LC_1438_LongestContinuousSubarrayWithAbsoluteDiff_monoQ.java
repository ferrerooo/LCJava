import java.util.*;

public class LC_1438_LongestContinuousSubarrayWithAbsoluteDiff_monoQ {
    
    public int longestSubarray(int[] nums, int limit) {
        
        Deque<Integer> maxq = new LinkedList<>();
        Deque<Integer> minq = new LinkedList<>();

        int start = 0;
        int res = 0;

        for (int i=0; i<nums.length; i++) {

            while (maxq.size() > 0 && nums[maxq.peekLast()] < nums[i] ) {
                maxq.pollLast();
            }
            maxq.offerLast(i);

            while (minq.size() > 0 && nums[minq.peekLast()] > nums[i] ) {
                minq.pollLast();
            }
            minq.offerLast(i);

            if (nums[maxq.peekFirst()] - nums[minq.peekFirst()] > limit) {
                if (nums[maxq.peekFirst()] == nums[start]) {
                    maxq.pollFirst();
                }
                if (nums[minq.peekFirst()] == nums[start]) {
                    minq.pollFirst();
                }

                start++;
            }

            res = Math.max(res, i-start+1);
        }

        return res;

    }
}