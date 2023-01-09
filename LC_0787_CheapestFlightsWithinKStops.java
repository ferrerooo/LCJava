import java.util.*;

public class LC_0787_CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        Map<Integer, Map<Integer, Integer>> adjMap = new HashMap<>();

        for (int[] unit : flights) {
            adjMap.putIfAbsent(unit[0], new HashMap<Integer, Integer>());
            adjMap.get(unit[0]).put(unit[1], unit[2]);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});
        int res = Integer.MAX_VALUE;

        // current min price (value) that from src to current city(key)
        Map<Integer, Integer> curMin = new HashMap<>();
        curMin.put(src, 0);

        for (int i=0; i<=k; i++) {

            Queue<int[]> next = new LinkedList<>();
            while (queue.size() >0) {
                int[] cur = queue.poll();
                Map<Integer, Integer> nextStop = adjMap.get(cur[0]);
                if (nextStop != null) {
                    for (Map.Entry<Integer, Integer> entry : nextStop.entrySet()) {
                        if (entry.getValue()+cur[1] < res) {
                            
                            if (!curMin.containsKey(entry.getKey())) {
                                curMin.put(entry.getKey(), entry.getValue()+cur[1]);
                            } else {
                                if (curMin.get(entry.getKey()) <= entry.getValue()+cur[1] )
                                    continue;
                                else 
                                    curMin.put(entry.getKey(), entry.getValue()+cur[1]);
                            }

                            next.offer(new int[]{entry.getKey(), entry.getValue()+cur[1]});

                            if (entry.getKey() == dst) {
                                res = Math.min(res, entry.getValue()+cur[1]);
                            }
                        } 
                    }
                }              
            }

            queue = next;
        }

        if (res != Integer.MAX_VALUE)
            return res;
        else
            return -1;

    }
}