import java.util.*;

public class LC_0692_TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();

        for (String s : words) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s)+1);
            }
        }
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((x,y)->{
            if (x.getValue() != y.getValue()) {
                return y.getValue() - x.getValue();
            } else {
                return x.getKey().compareTo(y.getKey());
            }
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        } 

        List<String> list = new ArrayList<>();

        for (int i=0; i<k; i++) {
            Map.Entry<String, Integer> entry = pq.poll();
            list.add(entry.getKey());
        }

        return list;
    }
}