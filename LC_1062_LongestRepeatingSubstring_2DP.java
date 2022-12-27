public class LC_1062_LongestRepeatingSubstring_2DP {
    public int longestRepeatingSubstring(String s) {

        int n = s.length();
        int res = 0;
        int[][] dp = new int[n][n];

        for (int i=0; i<n;i++){
            for (int j=i+1; j<n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i == 0)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = 1 + dp[i-1][j-1];
                    res = Math.max(res, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return res;
    }
}