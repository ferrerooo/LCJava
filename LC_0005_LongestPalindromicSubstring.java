public class LC_0005_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {

        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int maxLen = 1;
        int maxX = 0;
        int maxY = 0;

        for (int i=0; i<len; i++) {
            dp[i][i] = true;
        }

        for (int i=0; i<len-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
                if (2>maxLen) {
                    maxLen = 2;
                    maxX = i;
                    maxY = i+1;
                }
            } else
                dp[i][i+1] = false;
        }

        for (int d=2; d<len; d++) {
            for (int i=0; i<len-d; i++) {

                if (s.charAt(i) == s.charAt(i+d)) {
                    dp[i][i+d] = dp[i+1][i+d-1];
                } else {
                    dp[i][i+d] = false;
                }

                if (dp[i][i+d] == true && d+1 > maxLen) {
                    maxLen = d+1;
                    maxX = i;
                    maxY = i+d;
                }
            }
        }
        
        return s.substring(maxX, maxY+1);
    }
}