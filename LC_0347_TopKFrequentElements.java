import java.util.*;

public class LC_0347_TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i : nums) {
            
            if (map.containsKey(i))
                map.put(i, map.get(i)+1);
            else
                map.put(i, 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((x, y) -> y.getValue() - x.getValue());
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }
        
        for (int i=0; i<k; i++) {
            result[i] = pq.poll().getKey();
        }
        
        return result;
    }
    
}
