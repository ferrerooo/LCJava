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


/*
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
		Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

		for (int n : nums) {
			frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
		}

		for (int key : frequencyMap.keySet()) {
			int frequency = frequencyMap.get(key);
			if (bucket[frequency] == null) {
				bucket[frequency] = new ArrayList<>();
			}
			
			bucket[frequency].add(key);
		}

		List<Integer> res = new ArrayList<>();

		for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
			if (bucket[pos] != null) {
				res.addAll(bucket[pos]);
			}
		}
		
		int[] ans = new int[res.size()];

		for (int i=0; i<res.size(); i++) {
			ans[i] = res.get(i);
		}

		return ans;
    }
}

*/
