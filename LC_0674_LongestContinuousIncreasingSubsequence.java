public class LC_0674_LongestContinuousIncreasingSubsequence {
    
    public int findLengthOfLCIS(int[] nums) {
        
        int result = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;

        for (int i=1; i<dp.length; i++) {
            if (nums[i] > nums[i-1]) {
                dp[i] = dp[i-1] + 1;
                result = Math.max(result, dp[i]);
            } else {
                dp[i] = 1;
            }
        }

        return result;
    }

}
