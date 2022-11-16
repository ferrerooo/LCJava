public class LC_0583_DeleteOperationForTwoStrings {

    public int minDistance(String word1, String word2) {
        
        int len1 = word1.length();
        int len2 = word2.length();
        
        int[][] dp = new int[len1+1][len2+1];
        
        for (int i=0; i<len2+1; i++) {
            dp[0][i] = i;
        }
        
        for (int i=0; i<len1+1; i++) {
            dp[i][0] = i;
        }
        
        for (int row = 1; row < len1+1; row++) {
            for (int col = 1; col < len2+1; col++) {
                if (word1.charAt(row-1) == word2.charAt(col-1)) {
                    dp[row][col] = Math.min(dp[row-1][col-1], Math.min(dp[row-1][col]+1, dp[row][col-1]+1));
                } else {
                    dp[row][col] = Math.min(dp[row-1][col]+1, dp[row][col-1]+1);
                }
            }
        }
        
        return dp[len1][len2];
    }
    
}
