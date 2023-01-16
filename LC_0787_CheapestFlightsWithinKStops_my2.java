import java.util.*;

public class LC_0787_CheapestFlightsWithinKStops_my2 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        Map<Integer, List<int[]>> map = new HashMap<>();

        for (int[] f : flights) {
            int key = f[0];
            int[] pair = new int[]{f[1], f[2]};
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(pair);
        }

        List<int[]> cur = new ArrayList<>();
        cur.add(new int[]{src, 0});
        int result = Integer.MAX_VALUE;
        int loop = -1;
        List<int[]> next = new ArrayList<>();
        Map<Integer, Integer> maxMap = new HashMap<>();
        for (int i=0;i<n;i++) {
            maxMap.put(i, Integer.MAX_VALUE);
        }
        maxMap.put(src, 0);

        while (cur.size() > 0 && loop < k) {

            for (int[] pair : cur) {

                int start = pair[0];
                if (!map.containsKey(start))
                    continue;

                List<int[]> ends = map.get(start);

                for (int[] end : ends) {
                    
                    int[] newpair = new int[]{end[0], pair[1]+end[1]};
                    
                    if (newpair[0] == dst) {
                        result = Math.min(result, newpair[1]);
                    }

                    if (newpair[1] <= result && maxMap.get(newpair[0]) > newpair[1]) {
                        next.add(newpair);
                        maxMap.put(newpair[0], newpair[1]);
                    }
                }
            }

            cur = next;
            next = new ArrayList<>();
            loop++;
        }

        if (result == Integer.MAX_VALUE)
            return -1;
        else
            return result;
    }
}