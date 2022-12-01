import java.util.*;

public class LC_1845_SeatReservationManager {

    private PriorityQueue<Integer> pq;

    public LC_1845_SeatReservationManager(int n) {
        
        pq = new PriorityQueue<>();
        for (int i = 1; i<=n; i++)
            pq.offer(i);
    }
    
    public int reserve() {
        return pq.poll();
    }
    
    public void unreserve(int seatNumber) {
        pq.offer(seatNumber);
    }
    
}
