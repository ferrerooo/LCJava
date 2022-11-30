import java.util.*;

public class LC_0239_SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Deque<Integer> deque = new LinkedList<>();
        int[] results = new int[nums.length-k+1];
        
        this.init(deque, nums, k);
        
        for (int i=0; i<nums.length-k+1; i++) {
            
            results[i] = nums[deque.peekFirst()];
            if (i == nums.length-k)
                break;
            
            // index i move out; index i+k move in;
            if (deque.peekFirst() == i) {
                deque.pollFirst();
            }
            
            while (deque.size() != 0 && nums[deque.peekLast()] < nums[i+k])
                deque.pollLast();
            
            deque.offerLast(i+k);
        }
        
        return results;
    }
    
    private void init(Deque<Integer> deque, int[] nums, int k) {
        
        for (int i=0; i<k; i++) {
            
            while (deque.size() != 0 && nums[deque.peekLast()] < nums[i])
                deque.pollLast();
            
            deque.offerLast(i);
        }
        
    }
    
}
