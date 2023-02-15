public class LC_0680_ValidPalindromeII_my2 {
    
    public boolean validPalindrome(String s) {

        if (s == null)
            return false;
        
        if (isPal(s, 0, s.length()-1))
            return true;

        int p1 = 0;
        int p2 = s.length()-1;

        while (p1<=p2) {

            if (s.charAt(p1) == s.charAt(p2)) {
                p1++;
                p2--;
            } else {
                break;
            }
        }
        
        boolean b1 = isPal(s, p1+1, p2);
        boolean b2 = isPal(s, p1, p2-1);

        if (b1 || b2) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isPal(String s, int p1, int p2) {
        while (p1 <= p2) {
            if (s.charAt(p1) == s.charAt(p2)) {
                p1++;
                p2--;
            } else {
                return false;
            }

        }

        return true;
    }
}