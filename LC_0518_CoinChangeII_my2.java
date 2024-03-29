public class LC_0518_CoinChangeII_my2 {
    public int change(int amount, int[] coins) {
        
        int[] dp = new int[amount+1];
        dp[0] = 1;
        
        for (int coin : coins) {
            for (int i=1; i<dp.length; i++) {
                int index = i - coin;
                if (index >= 0) {
                    dp[i] = dp[i] + dp[i-coin];
                }
            }
        }

        return dp[amount];
    }
}