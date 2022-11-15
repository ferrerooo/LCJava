import java.util.*;

class LC_1658_MinimumOperationsToReduceXtoZero {
    
    public int minOperations(int[] nums, int x) {
        
        if (nums.length ==1 && nums[0] == x)
            return 1;
        
        int sum = 0;
        for (int i : nums)
            sum = sum + i;
    
        int target = sum - x;
        int result = -1;
        
        int p1 = 0;
        int p2 = 0;
        int aggr = nums[0];
        
        while (p1<nums.length && p2 < nums.length) {
            
            if (aggr == target) {
                result = Math.max(result, p2-p1+1);
                aggr = aggr - nums[p1];
                p1++;
            } else if (aggr < target) {
                p2++;
                if (p2 < nums.length)
                    aggr = aggr + nums[p2];
            } else {
                aggr = aggr - nums[p1];
                p1++;
            }
        }
        
        if (result == -1)
            return -1;
        else
            return nums.length - result;
    }

    /*public int minOperations(int[] nums, int x) {
        
        LinkedList<Status> list = new LinkedList<>();
        LinkedList<Status> newlist = new LinkedList<>();
        
        Status root = new Status(x, 0, nums.length - 1);
        list.offer(root);
        int min = 0;
        
        
        while (list.size() >0 ) {
            
            Status s = list.poll();
            
            if (s.right - s.left >= 0) {
                Status newS1 = new Status(s.value-nums[s.left], s.left+1, s.right);
                if (newS1.value == 0) {
                    min = min + 1;
                    return min;
                }
                if (newS1.value > 0) {
                    newlist.offer(newS1);
                }
            
                Status newS2 = new Status(s.value-nums[s.right], s.left, s.right-1);
                if (newS2.value == 0) {
                    min = min + 1;
                    return min;
                }
                if (newS2.value > 0) {
                    newlist.offer(newS2);
                }
            }
            
            if (list.size() == 0) {
                list = newlist;
                newlist = new LinkedList<>();
                min = min + 1;
            }
            
        } 
        
        return -1;
    }
    
    class Status {
        public Status(int v, int l, int r) {
            this.value = v;
            this.left = l;
            this.right = r;
        }
        public int value;
        public int left;
        public int right;
    }*/
}