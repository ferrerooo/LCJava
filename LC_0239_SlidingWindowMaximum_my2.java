import java.util.*;

public class LC_0239_SlidingWindowMaximum_my2 {
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Deque<Integer> maxq = new LinkedList<>();

        for (int i=0; i<k ;i++) {

            while (maxq.size()>0 && nums[maxq.peekLast()] < nums[i]) {
                maxq.pollLast();
            }

            maxq.offerLast(i);
        }

        int[] ans = new int[nums.length-k+1];

        for (int i=0; i<nums.length-k+1; i++) {

            ans[i] = nums[maxq.peekFirst()];

            if (i == nums.length-k) {
                break;
            }

            if (nums[i] == nums[maxq.peekFirst()]) {
                maxq.pollFirst();
            } 

            while (maxq.size() > 0 && nums[maxq.peekLast()] < nums[i+k]) {
                maxq.pollLast();
            }

            maxq.offerLast(i+k);
        }

        return ans;
    }
}