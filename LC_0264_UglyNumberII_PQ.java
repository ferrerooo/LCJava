import java.util.*;

public class LC_0264_UglyNumberII_PQ {
    public int nthUglyNumber(int n) {

        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> visited = new HashSet<>();
        pq.offer(1L);
        visited.add(1L);
        int count = 0;

        while (pq.size() > 0) {

            long cur = pq.poll();
            count ++;

            if (count == n) {
                return (int)cur;
            }

                if (!visited.contains(2*cur)) {
                    visited.add(2*cur);
                    pq.offer(2*cur);
                }

                if (!visited.contains(3*cur)) {
                    visited.add(3*cur);
                    pq.offer(3*cur);
                }

                if (!visited.contains(5*cur)) {
                    visited.add(5*cur);
                    pq.offer(5*cur);
                }
            
        }
        
        return 0;
    }
}