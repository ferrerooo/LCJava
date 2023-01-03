public class LC_0877_StoneGame_DP {

    public boolean stoneGame(int[] piles) {
        
        int n = piles.length;

        // dp[i][j] means, from piles i to j, (and both A and B do their optimal moves), for the current person to move, what is his optimal relative score.
        int[][] dp = new int[n][n];

        for (int i=0 ;i<n; i++)
            dp[i][i] = piles[i];
        
        for (int i=1; i<n; i++) {
            for (int j=0; j+i<n; j++) {

                dp[j][j+i] = Math.max(piles[j+i]-dp[j][j+i-1], piles[j]-dp[j+1][j+i]);

            }
        }

        return dp[0][n-1] > 0;
    }
}
    
}
