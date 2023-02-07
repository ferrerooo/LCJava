import java.util.*;

public class LC_0281_ZigzagIterator {
    Queue<List<Integer>> q;

    public LC_0281_ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        q = new LinkedList<>();
        if (v1 != null && v1.size() >0 )
            q.offer(v1);
        if (v2 != null && v2.size() >0 )
            q.offer(v2);
    }

    public int next() {
        List<Integer> cur = q.poll();
        int result = cur.get(0);
        cur.remove(0);
        if (cur.size() > 0)
            q.offer(cur);
        return result;
    }

    public boolean hasNext() {
        return q.size()>0;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */