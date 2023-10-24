public class ZigzagIterator {

    private Queue<List<Integer>> q;
    private Queue<Integer> qIndex;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        
        q = new LinkedList<>();
        qIndex = new LinkedList<>();
        
        if (v1.size() > 0) {
            q.offer(v1);
            qIndex.offer(0);
        }
        
        if (v2.size() > 0) {
            q.offer(v2);
            qIndex.offer(0);
        }
    }

    public int next() {
        
        List<Integer> l = q.poll();
        int index = qIndex.poll();

        int result = l.get(index);

        index ++;
        if (index < l.size()) {
            q.offer(l);
            qIndex.offer(index);
        }

        return result;

    }

    public boolean hasNext() {
        
        if (q.size() > 0)
            return true;
        else
            return false;

    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
