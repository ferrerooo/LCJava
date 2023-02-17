public class LC_0518_CoinChangeII_dp {
    
    public int change(int amount, int[] coins) {
        
        int[] dp = new int[amount+1];
        dp[0] = 1;

        for (int coin : coins) {

            int cur = coin;

            while (cur <= amount) {

                dp[cur] = dp[cur] + dp[cur-coin];
                cur++;
            }
        }

        return dp[amount];

        /*

        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int x = coin; x < amount + 1; ++x) {
                dp[x] += dp[x - coin];
            }
        }
        
        return dp[amount];*/
    }
}