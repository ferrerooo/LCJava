import java.util.*;

public class LC_0295_FindMedianfromDataStream_my2 {
    PriorityQueue<Integer> minh = null;
    PriorityQueue<Integer> maxh = null;

    public LC_0295_FindMedianfromDataStream_my2() {
        minh = new PriorityQueue<>();
        maxh = new PriorityQueue<>((x,y)-> y-x);
    }
    
    public void addNum(int num) {
        
        if (maxh.size() == 0) {
            maxh.offer(num);
        } else if (maxh.peek()>= num) {
            maxh.offer(num);
        } else if (minh.size() == 0) {
            minh.offer(num);
        } else if (minh.peek() > num) {
            maxh.offer(num);
        } else if (minh.peek() <= num) {
            minh.offer(num);
        }

        rebalance(minh, maxh);

    }

    private void rebalance (PriorityQueue<Integer> minh, PriorityQueue<Integer> maxh) {
 
        while (Math.abs(maxh.size()-minh.size()) > 1) {
            if (maxh.size() > minh.size()) {
                minh.offer(maxh.poll());
            } else {
                maxh.offer(minh.poll());
            }
        }

        if (minh.size() == maxh.size() || minh.size() + 1 == maxh.size())
            return ;

        maxh.offer(minh.poll());
        return;

    }
    
    public double findMedian() {
        
        if (minh.size() == maxh.size()) {
            return ((double)minh.peek()+maxh.peek())/2;
        }

        return maxh.peek();

    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */