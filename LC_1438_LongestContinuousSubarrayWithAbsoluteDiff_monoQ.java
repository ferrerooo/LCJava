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

/*

class Solution {
    public int longestSubarray(int[] nums, int limit) {

        int len = nums.length;

        Deque<Integer> maxdq = new LinkedList<>();
        Deque<Integer> mindq = new LinkedList<>();

        System.out.println("limit is : " + limit);
        int start = 0;
        int res = 0;

        for (int i=0 ;i<len; i++) {

            while (maxdq.size() > 0 && nums[maxdq.peekLast()] < nums[i]) {
                maxdq.pollLast();
            }

            maxdq.offerLast(i);

            while (mindq.size() > 0 && nums[mindq.peekLast()] > nums[i]) {
                mindq.pollLast();
            }

            mindq.offerLast(i);

            if (nums[maxdq.peekFirst()] - nums[mindq.peekFirst()] <= limit) {
                res = Math.max(res, i-start+1);
            }

            while (nums[maxdq.peekFirst()] - nums[mindq.peekFirst()] > limit) {

                System.out.println("start:"+start);

                if (nums[start] < nums[maxdq.peekFirst()] && nums[start] > nums[mindq.peekFirst()]) {
                    System.out.println("case1");
                    System.out.println("maxdq.peekFirst():"+maxdq.peekFirst());
                    System.out.println("mindq.peekFirst():"+mindq.peekFirst());
                    start ++;
                    continue;
                } 

                if (nums[start] == nums[maxdq.peekFirst()]) {
                    System.out.println("case2");
                    start ++;
                    maxdq.pollFirst();
                    continue;
                }

                if (nums[start] == nums[mindq.peekFirst()]) {
                    System.out.println("case3");
                    start ++;
                    mindq.pollFirst();
                    continue;
                }
            }
        }

        return res;
        
    }
}
*/
