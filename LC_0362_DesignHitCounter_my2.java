import java.util.*;

public class LC_0362_DesignHitCounter_my2 {
    private List<Integer> list;

    public LC_0362_DesignHitCounter_my2() {
        list = new ArrayList<>();
    }
    
    public void hit(int timestamp) {
        list.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        int count = 0;
        int earliest = timestamp  - 300;
        for (int i=list.size()-1; i>=0; i--) {
            if (list.get(i) > earliest) {
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */