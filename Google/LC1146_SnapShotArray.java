package Google;

import java.util.*;

class SnapshotArray {
    /* 
    private TreeMap<Integer, Integer>[] arr;
    private int curId;
    
    public SnapshotArray(int length) {
        arr = new TreeMap[length];
        curId = 0;
        for (int i = 0; i<length; i++) {
            TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
            map.put(0, 0);
            arr[i] = map;
        }
    }
    
    public void set(int index, int val) {
        arr[index].put(curId, val);
    }
    
    public int snap() {
        curId++;
    }
    
    public int get(int index, int snap_id) {
        
        TreeMap<Integer, Integer> map = arr[index];
        Map.Entry<Integer, Integer> entry = map.floorEntry(snap_id);
        return entry.getValue();
        
    }
    */
    
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */