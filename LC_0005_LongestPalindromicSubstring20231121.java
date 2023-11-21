class Solution {
    public String longestPalindrome(String s) {

        int len = s.length();

        boolean[][] isPal = new boolean[len][len];

        String result = s.substring(0,1);
        int maxLen = 1;

        for (int i=0; i<len; i++) {
            isPal[i][i] = true;

            if (i+1<len && s.charAt(i) == s.charAt(i+1)) {
                isPal[i][i+1] = true;
                maxLen = 2;
                result = s.substring(i,i+2);
            }
        }

        for (int i=2; i<len; i++) {
            for (int j=0; j<len-i; j++) {
                int row = j;
                int col = j+i;
                if (s.charAt(row) == s.charAt(col) && isPal[row+1][col-1]) {
                    isPal[row][col] = true;
                    if (col-row+1 > maxLen) {
                        maxLen = col-row+1;
                        result = s.substring(row, col+1);
                    }
                }
            }
        }

        return result;
        
    }
}
