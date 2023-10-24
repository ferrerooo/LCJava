class Solution {
    public int maxLength(int[] ribbons, int k) {
        
        int p1 = 1;
        int p2 = ribbons[0];

        for (int i: ribbons) {
            p2 = Math.max(p2, i);
        }

        int res = 0;

        while (p1<=p2) {

            int m = p1 + (p2-p1)/2;

            int count = 0;
            for (int i:ribbons) {
                count = count + i/m;
            }

            if (count < k) {
                p2 = m-1;
            } else {
                p1 = m+1;
                res = Math.max(res, m);
            }
        }
        
        return res;
    }
}
