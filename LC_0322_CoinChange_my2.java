public class LC_0322_CoinChange_my2 {
    public int coinChange(int[] coins, int amount) {
        
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i=1; i<dp.length; i++) {
            
            int localmin = Integer.MAX_VALUE;

            for (int c:coins) {

                if (i-c>=0 && dp[i-c] != Integer.MAX_VALUE) {
                    localmin = Math.min(localmin, dp[i-c]+1);
                }
            }

            dp[i] = localmin;
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}