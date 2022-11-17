public class LC_0322_CoinChange {
    public int coinChange(int[] coins, int amount) {
        
        if (amount == 0)
            return 0;
        
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        
        for (int coin : coins) {
            if (coin <= amount)
                dp[coin] = 1;
        }
        
        for (int i = 1; i<= amount; i++) {
            
            if (dp[i] == 1) {
                continue;
            }
            
            int localMin = Integer.MAX_VALUE;
            
            for (int coin : coins) {
                
                if (i - coin >= 0 && dp[i-coin] != -1) {
                    localMin = Math.min(localMin, dp[i-coin] + 1);
                }
            }
            
            if (localMin == Integer.MAX_VALUE)
                dp[i] = -1;
            else
                dp[i] = localMin;
        }
        
        for (int x : dp)
            System.out.print(x + ", ");
        
        return dp[amount];
    }
}