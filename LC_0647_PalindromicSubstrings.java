class Solution {
    public int countSubstrings(String s) {

        int len = s.length();

        boolean[][] dp = new boolean[len][len];
        int count = 0;

        for (int i=0; i<len; i++) {
            dp[i][i] = true;
            count++;
        }

        for (int i=0; i<len-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
                count++;
            } else {
                dp[i][i+1] = false;
            }
        }

        for (int d = 2; d<len; d++) {
            for (int i=0; i<len-d; i++) {
                if (s.charAt(i) == s.charAt(i+d) && dp[i+1][i+d-1]) {
                    dp[i][i+d] = true;
                    count++;
                } else {
                    dp[i][i+d] = false;
                }
            }
        }
        
        return count;
    }
}
