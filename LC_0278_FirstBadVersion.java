public class LC_0278_FirstBadVersion {
    public int firstBadVersion(int n) {

        int p1 = 1;
        int p2 = n;

        while (p1 <= p2) {

            int m = p1 + (p2-p1)/2;

            if (isBadVersion(m) == false) {
                p1 = m+1;
            } else {

                if (m == p1 || isBadVersion(m-1) == false) {
                    return m;
                } else {
                    p2 = m-1;
                }

            }
        }
        
        return -1;
    }

    private boolean isBadVersion(int n) {
        return true;
    }
}