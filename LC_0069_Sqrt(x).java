class Solution {
    public int mySqrt(int xint) {
        
        long x = (long)xint;

        /*if (x == 0)
            return 0;*/
        
        if (x == 1)
            return 1;
        
        long p1 = 0;
        long p2 = x/2;

        while (p1<=p2) {
            
            long m = p1 + (p2-p1)/2;
            long a = m*m;
            long b = (m+1)*(m+1);

            if (a == x)
                return (int)m;
            else if (a<x && b>x)
                return (int)m;
            else if (a > x) {
                p2 = m-1;
            } else {
                p1 = m+1;
            }
        }

        return -1;
    }
}
