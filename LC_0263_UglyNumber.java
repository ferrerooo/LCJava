class Solution {
    public boolean isUgly(int n) {

        if (n < 1)
            return false;
        
        if (n == 1)
            return true;

        long l = n;

        System.out.println(l);

        while (l != 1L) {

            if (l % 5 == 0) {
                l = l/5;
            } else if (l % 3 == 0) {
                l = l/3;
            } else if (l % 2 == 0) {
                l = l/2;
            } else {
                return false;
            }

        }

        return true;
        
    }
}
