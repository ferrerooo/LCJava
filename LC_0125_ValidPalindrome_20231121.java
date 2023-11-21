class Solution {
    public boolean isPalindrome(String s) {
        
        int p1 = 0;
        int p2 = s.length()-1;

        p1 = findForward(s, p1);
        p2 = findBackward(s, p2);

        while (p1 < p2) {
            if (!palEqual(s, p1, p2)) {

                return false;
            }

            p1 = findForward(s, p1+1);
            p2 = findBackward(s, p2-1);
        }

        return true;
    }

    private boolean palEqual(String s, int p1, int p2) {

        char c1 = s.charAt(p1);
        char c2 = s.charAt(p2);

        System.out.println("comparing "+p1+":"+c1+" with "+p2+":"+c2);

        if (c1 >= 'A' && c1<='Z') {
            c1 = (char)((int)c1 - ('A'-'a'));
        }

        if (c2 >= 'A' && c2<='Z') {
            c2 = (char)((int)c2 - ('A'-'a'));
        }

        return c1 == c2;
    }

    private int findForward(String s, int p) {
        while ( p<s.length() && !isAlpha(s.charAt(p)) ) {
            p++;
        }
        
        return p;
        
    }

    private int findBackward(String s, int p) {
        while ( p>=0 && !isAlpha(s.charAt(p)) ) {
            p--;
        }
        
        return p;
    }

    private boolean isAlpha(char c) {

        if ((c >= 'a' && c <= 'z') 
                || (c >= 'A' && c <= 'Z')  
                || (c>='0' && c<='9') ) {
                    return true;
                }
            
        return false;
    }
}
