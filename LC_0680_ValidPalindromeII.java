public class LC_0680_ValidPalindromeII {
    public boolean validPalindrome(String s) {
        
        int p1 = 0;
        int p2 = s.length() - 1;

        while (p1 < p2) {

            if (s.charAt(p1) == s.charAt(p2)) {
                p1++;
                p2--;
                continue;
            }

            boolean b1 = this.isPalin(s, p1+1, p2);
            boolean b2 = this.isPalin(s, p1, p2-1);

            if (b1 || b2)
                return true;
            else    
                return false;
        }

        return true;
    }

    private boolean isPalin(String s, int p1, int p2) {

        while (p1 < p2) {
            if (s.charAt(p1) == s.charAt(p2)) {
                p1++;
                p2--;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}