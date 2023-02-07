import java.util.*;

public class LC_0815_BusRoutes_my2 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        if (source == target) {
            return 0;
        }

        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i=0; i<routes.length; i++) {
            int[] rs = routes[i];
            for (int r:rs) {
                map.putIfAbsent(r, new HashSet<>());
                map.get(r).add(i);
            }
        }

        Set<Integer> cur = new HashSet<>();
        Set<Integer> next = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> visitedRoute = new HashSet<>();

        for (int rindex : map.get(source)) {
            visitedRoute.add(rindex);
            for (int stop : routes[rindex]) {
                cur.add(stop);
                visited.add(stop);
            }
        }

        int step = 1;

        if (cur.contains(target)) {
            return step;
        }

        while (cur.size() > 0) {

            for (int stop : cur) {

                for (int rindex : map.get(stop)) {

                    if (visitedRoute.contains(rindex)) {
                        continue;
                    }

                    visitedRoute.add(rindex);

                    for (int nextstop : routes[rindex]) {
                        if (visited.contains(nextstop)) {
                            continue;
                        }
                        next.add(nextstop);
                        visited.add(nextstop);
                    }
                }
            }

            step++;

            if (next.contains(target)) {
                return step;
            }

            cur = next;
            next = new HashSet<>();

        }

        return -1;
    }
}