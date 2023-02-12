import java.util.*;

public class LC_0380_InsertDeleteGetRandomO1 {
    
    
    private Map<Integer, Integer> map;  // value to index
    private List<Integer> list;
    private Random r;

    public LC_0380_InsertDeleteGetRandomO1() {
        map = new HashMap<>();
        list = new ArrayList<>();
        r = new Random();
    }
    
    public boolean insert(int val) {
        
        if (map.containsKey(val))
            return false;
        
        list.add(val);
        map.put(val, list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        
        int index = map.get(val);
        map.remove(val);
        if (index == list.size()-1) {
            list.remove(list.size()-1);
        } else {
            int v = list.get(list.size()-1);
            list.set(index, v);
            map.put(v, index);
            list.remove(list.size()-1);
        }

        return true;
    }
    
    public int getRandom() {
        int i = r.nextInt(list.size());
        return list.get(i);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */