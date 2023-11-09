import java.util.*;

public class LC_1438_ContinuousSubarrayWithAbsoluteDiff_PQ_my2 {
    public int longestSubarray(int[] nums, int limit) {
        
        PriorityQueue<int[]> minQ = new PriorityQueue<>((a, b) -> a[0] - b[0]);
	    PriorityQueue<int[]> maxQ = new PriorityQueue<>((a, b) -> b[0] - a[0]);

	    int j = 0;
	    int res = 0;
	    for (int i = 0; i < nums.length; i++) {
		    minQ.add(new int[]{nums[i], i});
		    maxQ.add(new int[]{nums[i], i});

		    while (maxQ.peek()[0] - minQ.peek()[0] > limit) {
			    j = Math.min(maxQ.peek()[1], minQ.peek()[1]) + 1;
			    while (minQ.peek()[1] < j) 
                    minQ.poll();
			    while (maxQ.peek()[1] < j) 
                    maxQ.poll();
		    }
		    res = Math.max(res, i - j + 1);
	    }

	    return res;
    }
}
