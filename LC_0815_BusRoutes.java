import java.util.*;

public class LC_0815_BusRoutes {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        if (source == target)
            return 0;

        Map<Integer, Set<Integer>> bToS = new HashMap<>();
        Map<Integer, Set<Integer>> sToB = new HashMap<>();

        int len = routes.length;
        for (int i=0; i<len ;i++) {
            int[] stations = routes[i];

            Set<Integer> set = new HashSet<>();
            for (int station: stations)
                set.add(station);

            bToS.put(i, set);

            for (int station:stations) {
                if (!sToB.containsKey(station)) {
                    sToB.put(station, new HashSet<>());
                }
                sToB.get(station).add(i);
            }
        }

        Set<Integer> startBuses = sToB.get(source);

        int minbuscount = Integer.MAX_VALUE;
        for (int startBus : startBuses) {

            minbuscount = Math.min(minbuscount, this.minBusCount(bToS, sToB, startBus, target));
        }

        if (minbuscount == Integer.MAX_VALUE)
            return -1;
        
        return minbuscount;
    }

    private int minBusCount(Map<Integer, Set<Integer>> bToS, Map<Integer, Set<Integer>> sToB, int startBus, int targetStation) {
        
        int count = 1;
        if (bToS.get(startBus).contains(targetStation))
            return count;
        
        Set<Integer> visitedBus = new HashSet<>();
        visitedBus.add(startBus);

        Queue<Integer> q = new LinkedList<>();
        q.offer(startBus);

        while (q.size() > 0) {

             Set<Integer> buses = new HashSet<>();

            while (q.size() > 0) {
                int bus = q.poll();
                Set<Integer> stations = bToS.get(bus);
                for (int station : stations) {
                    Set<Integer> localBuses = sToB.get(station);
                    for (int b : localBuses) {
                        if (!visitedBus.contains(b)) 
                            buses.add(b);
                    }
                }
            }
            q = new LinkedList<>();
            for (int b : buses) {
                visitedBus.add(b);
                q.offer(b);
                if (bToS.get(b).contains(targetStation))
                    return count + 1;
            }
            count++;
        }

        return Integer.MAX_VALUE;
    }
}