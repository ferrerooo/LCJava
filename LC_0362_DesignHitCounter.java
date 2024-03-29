

import java.util.*;

class LC_0362_DesignHitCounter {

    private LinkedList<Integer> q;
    
    public LC_0362_DesignHitCounter() {
        q = new LinkedList<>();   
    }
    
    public void hit(int timestamp) {
        q.offer(timestamp);
    }
    
    public int getHits(int timestamp) {
        
        int hitsCount = 0;
        for (int i = q.size() - 1; i >=0 ; i--) {
            if (q.get(i) > timestamp - 300)
                hitsCount++;
            else
                break;
        }
        
        return hitsCount;
    }
}

/*
class HitCounter {

    private Queue<Integer> queue;

    public HitCounter() {
        queue = new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        queue.offer(timestamp);
    }
    
    public int getHits(int timestamp) {
        
        int earliestTimeStamp = timestamp - 300;
        while (queue.size()>0 && queue.peek()<= earliestTimeStamp) {
            queue.poll();
        }

        return queue.size();
    }
}
*/

/*
 * 
 * class HitCounter {

    private LinkedList<Integer> q;
    private final int MIN5WINDOW = 300;
    
    public HitCounter() {
        q = new LinkedList();   
    }
    
    public void hit(int timestamp) {
        q.offer(timestamp);
        while (q.peek() <= timestamp - MIN5WINDOW )
            q.poll();
    }
    
    public int getHits(int timestamp) {
        
        while (q.peek() != null 
                && q.peek() <= timestamp - MIN5WINDOW )
            q.poll();
        return q.size();
    }
}
*/
