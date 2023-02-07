import java.util.*;

public class LC_0346_MovingAveragefromDataStream {
    private Queue<Integer> q;
    private int size;
    private double sum;

    public LC_0346_MovingAveragefromDataStream(int size) {
        this.size = size;
        q = new LinkedList<>();
        sum = 0;
    }
    
    public double next(int val) {
        
        sum = sum + val;
        q.offer(val);

        while (q.size() > size) {
            sum = sum - q.poll();
        }

        return sum / q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */