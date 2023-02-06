import java.util.*;

public class LC_0323_NumberofConnectedComponentsinanUndirectedGraph_BFS_my2 {
    
    public int countComponents(int n, int[][] edges) {
        
        Set<Integer> visited = new HashSet<>();
        int count = 0;

        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i=0; i<n; i++) {           
            map.put(i, new HashSet<>());
        }

        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        for (int i=0; i<n; i++) {

            if (visited.contains(i)) {
                continue;
            }

            count++;

            LinkedList<Integer> cur = new LinkedList<>();
            visited.add(i);
            cur.add(i);

            while (cur.size() > 0) {

                int local = cur.poll();
                Set<Integer> neighbors = map.get(local);

                for (int neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        cur.add(neighbor);
                        visited.add(neighbor);
                    }
                } 
            }

        }

        return count;
    }

}