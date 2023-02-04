public class LC_1216_ValidPalindromeIII {
    
    public boolean isValidPalindrome(String s, int k) {

        int len = s.length();

        int[][] dp = new int[len][len];

        for (int i=0; i<len; i++) {
            dp[i][i] = 0;
        }

        for (int i=1; i<len; i++) {
            dp[i-1][i] = s.charAt(i-1) == s.charAt(i) ? 0 : 1;
        }

        for (int i=2; i<len; i++) {
            for (int j=0; j+i<len; j++) {
                if (s.charAt(j) == s.charAt(j+i)) {
                    dp[j][j+i] = dp[j+1][j+i-1];
                } else {
                    dp[j][j+i] = Math.min(dp[j+1][j+i]+1, dp[j][j+i-1]+1);
                }
            }
        }

        for (int i=0; i<len; i++) {
            for (int j=0; j<len; j++) {
                //System.out.print(dp[i][j] + ",");
            }
            //System.out.println();
        }
        
        return dp[0][len-1] <= k;
    }
}