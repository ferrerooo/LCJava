public class LC_0072_EditDistance {
    public int minDistance(String word1, String word2) {
        
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        
        for (int i=1; i<m+1; i++)
            dp[i][0] = i;
        
        for (int i=1; i<n+1; i++) 
            dp[0][i] = i;
        
        for (int i=1; i<m+1; i++) {
            for (int j=1; j<n+1;j++) {

                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1]+1, dp[i-1][j]+1));
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1]+1, Math.min(dp[i][j-1]+1, dp[i-1][j]+1));
                }

            }
        }

        return dp[m][n];
    }
}