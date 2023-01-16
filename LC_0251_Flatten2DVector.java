import java.util.*;

public class LC_0251_Flatten2DVector {
    private Queue<int[]> queue;
    private int p;

    public LC_0251_Flatten2DVector(int[][] vec) {
        
        queue = new LinkedList<>();
        for (int[] arr : vec) {
            if (arr != null && arr.length > 0) {
                queue.offer(arr);
            }
        }

        p = 0;
    }
    
    public int next() {
        
        int res = queue.peek()[p];
        p++;
        if (queue.peek().length<= p) {
            p=0;
            queue.poll();
        }

        return res;
    }
    
    public boolean hasNext() {
        return queue.size() > 0;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */