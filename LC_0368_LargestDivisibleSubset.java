import java.util.*;

public class LC_0368_LargestDivisibleSubset {
    
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        Arrays.sort(nums);
        Pair[] dp = new Pair[nums.length];
        dp[0] = new Pair(1, -1);
        int maxLen = 1;
        int maxLenIndex = 0;

        for (int i=1; i<nums.length; i++) {
            for (int j=i-1; j>=0; j--) {
                if (nums[i]%nums[j] == 0) {
                    Pair p = new Pair(dp[j].count+1, j);
                    if (dp[i] == null || dp[i].count<p.count) {
                        dp[i] = p;
                        if (dp[i].count > maxLen) {
                            maxLen = dp[i].count;
                            maxLenIndex = i;
                        }
                    }
                }
            }

            if (dp[i] == null) {
                dp[i] = new Pair(1, -1);
            }
        }

        for (Pair p : dp) {
            System.out.println(p.count + ","+p.pre);
        }

        List<Integer> list = new ArrayList<>();
        int curIndex = maxLenIndex;
        Pair cur = dp[curIndex];
        while (cur.pre != -1) {
            list.add(nums[curIndex]);
            curIndex = cur.pre;
            cur = dp[cur.pre];
        }

        list.add(nums[curIndex]);

        Collections.reverse(list);

        return list;
    }

    class Pair {
        private int count;
        private int pre;
        public Pair(int _count, int _pre) {
            this.count = _count;
            this.pre = _pre;
        }
    }
}