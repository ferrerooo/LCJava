import java.util.*;

public class LC_0215_KthLargestElementinanArray_Heap {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int n:nums) {

            if (pq.size() < k) {
                pq.offer(n);
            } else {
                if (n <= pq.peek()) {
                    continue;
                } else {
                    pq.poll();
                    pq.offer(n);
                }
            }
        }
        
        return pq.peek();
    }
}