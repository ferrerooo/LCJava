public class LC_0277_FindtheCelebrity {
    public int findCelebrity(int n) {

        int p1 = 0;
        int p2 = n-1;

        while (p1 < p2) {

            if (knows(p1, p2)) {
                p1++;
            } else {
                p2--;
            }
        }

        for (int i=0; i<n; i++) {
            
            if (p1 == i)
                continue;
            
            if (!knows(p1, i) && knows(i, p1))
                continue;
            else
                return -1;
        }
        
        return p1;
    }

    boolean knows(int a, int b){
        return false;
    }
}