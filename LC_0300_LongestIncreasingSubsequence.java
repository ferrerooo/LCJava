public class LC_0300_LongestIncreasingSubsequence {
    
    public int lengthOfLIS(int[] nums) {
        
        int[] dp = new int[nums.length];

        int p1 = 0;
        int p2 = 0;

        dp[0] = nums[0];

        for (int i=1; i<nums.length; i++) {

            int index = this.binarySearch(dp, p1, p2, nums[i]);
            dp[index] = nums[i];
            if (index > p2) {    
                p2++;
            } 
        }

        return p2+1;
    }

    private int binarySearch(int[] dp, int p1, int p2, int val) {
        
        if (val > dp[p2])
            return p2+1;
        
        while (p1 <= p2) {
            int m = p1 + (p2-p1)/2;
            if (dp[m] == val)
                return m;
            else if (dp[m] > val) {
                if (m == 0 || dp[m-1] < val) {
                    return m;
                } else {
                    p2 = m-1;
                }
            } else {
                p1 = m+1;
            }
        }

        return -1; // not reachable
    }

}
