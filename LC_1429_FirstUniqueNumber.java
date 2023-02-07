import java.util.*;

public class LC_1429_FirstUniqueNumber {
    private Queue<Integer> q;
    private Map<Integer, Integer> map;

    public LC_1429_FirstUniqueNumber(int[] nums) {
        q = new LinkedList<>();
        map = new HashMap<>();

        for (int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i: nums) {
            if (map.get(i) == 1) 
                q.offer(i);
        }
    }
    
    public int showFirstUnique() {
        if (q.size() == 0)
            return -1;
        return q.peek();
    }
    
    public void add(int value) {
        
        map.put(value, map.getOrDefault(value, 0) + 1);
        if (map.get(value) == 1)
            q.offer(value);
        
        while (q.size() > 0) {
            int head = q.peek();
            if (map.get(head) == 1) {
                return;
            } else {
                q.poll();
            }
        }

    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */