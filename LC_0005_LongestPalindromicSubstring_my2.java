public class LC_0005_LongestPalindromicSubstring_my2 {
    
    public String longestPalindrome(String s) {
        
        int len = s.length();

        boolean[][] dp = new boolean[len][len];

        int maxlen = 1;
        String ans = s.substring(0,1);

        for (int i=0; i<len; i++) {
            dp[i][i] = true;
        }

        for (int i=0; i<len-1; i++) {
            dp[i][i+1] = s.charAt(i) == s.charAt(i+1) ? true : false;
            
            if (dp[i][i+1] && maxlen < 2) {
                maxlen = 2;
                ans = s.substring(i, i+2);
            }
        }

        for (int i=2; i<len; i++) {
            for (int j=0; j+i<len; j++) {

                if (s.charAt(j) == s.charAt(j+i) && dp[j+1][j+i-1] == true) {
                    dp[j][j+i] = true;
                    if (maxlen < i+1) {
                        maxlen = i+1;
                        ans = s.substring(j, j+i+1);
                    }
                }

            }
        }

        return ans;

    }
}