import java.util.*;

public class LC_0251_Flatten2DVector_my1 {
    Queue<Integer> q;

    public LC_0251_Flatten2DVector_my1(int[][] vec) {
        q = new LinkedList<>();
        for (int[] arr : vec) {
            for (int i:arr) {
                q.offer(i);
            }
        }
    }
    
    public int next() {
        return q.poll();
    }
    
    public boolean hasNext() {
        return q.size() > 0;
    }
}