import java.util.*;

public class LC_1438_ContinuousSubarrayWithAbsoluteDiff_PQ_my1 {
    public int longestSubarray(int[] nums, int limit) {

        // arr[0] is val, arr[1] is index
        PriorityQueue<int[]> pqs = new PriorityQueue<>((x,y)-> {
            if (x[0] != y[0]) {
                return x[0]-y[0];
            } else {
                return y[1]-x[1];
            }
        });
        PriorityQueue<int[]> pql = new PriorityQueue<>((x,y)-> {
            if (x[0] != y[0]) {
                return y[0]-x[0];
            } else {
                return y[1]-x[1];
            }
        });

        int p1 = 0;
        int p2 = 0;
        int res = 0;

        while (p2 < nums.length) {

            pqs.offer(new int[]{nums[p2], p2});
            pql.offer(new int[]{nums[p2], p2});

            if (Math.abs(pqs.peek()[0] - pql.peek()[0]) <= limit) {
                res = Math.max(res, p2-p1+1);
                p2++;
                continue;
            } 

            while (Math.abs(pqs.peek()[0] - pql.peek()[0]) > limit) {
                int[] small = pqs.peek();
                int[] large = pql.peek();

                if (small[1] < large[1]) {
                    p1 = small[1] + 1;
                    while (pqs.peek()[1] < p1) {
                        pqs.poll();
                    }
                } else {
                    p1 = large[1] + 1;
                    while (pql.peek()[1] < p1) {
                        pql.poll();
                    }
                }
            }

            p2++;

        }


        return res;
    }
}