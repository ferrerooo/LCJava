public class LC_0486_PredicttheWinner_dp {
    public boolean PredictTheWinner(int[] nums) {
        
        int n = nums.length;

        // dp[i][j] means from nums i to j, current player's largest possible relative score
        int[][] dp = new int[n][n];

        for (int i=0; i<n; i++) {
            dp[i][i] = nums[i];
        }

        for (int i=1; i<n; i++) {
            for (int j=0; j+i<n; j++) {

                dp[j][j+i] = Math.max(nums[j]-dp[j+1][j+i], nums[j+i]-dp[j][j+i-1]);

            }
        }

        return dp[0][n-1] >= 0;
    }
}