import java.util.*;

public class LC_0295_FindMedianfromDataStream {
    
    PriorityQueue<Integer> pq1 = null;
    PriorityQueue<Integer> pq2 = null;

    public LC_0295_FindMedianfromDataStream() {
        pq1 = new PriorityQueue<>((x,y)->y-x);
        pq2 = new PriorityQueue<>((x,y)->x-y);
    }
    
    public void addNum(int num) {
        if (pq1.size() == 0) {
            pq1.offer(num);
            return;
        }

        if (num <= pq1.peek()) {
            pq1.offer(num);
        } else {
            pq2.offer(num);
        }

        if (pq1.size() - pq2.size() == 2) {
            pq2.offer(pq1.poll());
            return;
        } 

        if (pq2.size() - pq1.size() == 1) {
            pq1.offer(pq2.poll());
            return;
        }
    }
    
    public double findMedian() {
        int size = pq1.size()+pq2.size();

        if (size %2 == 1)
            return (double)pq1.peek();
        
        return ((double)pq1.peek() + pq2.peek()) / 2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

