import java.util.*;

public class LC_0323_NumberofConnectedComponentsinanUndirectedGraph_BFS_my1 {
    
    public int countComponents(int n, int[][] edges) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> graph = new HashSet<>();

        for (int[] edge : edges) {

            int a = edge[0];
            int b = edge[1];

            graph.add(a);
            graph.add(b);

            if (!map.containsKey(a))
                map.put(a, new LinkedList<>());
            if (!map.containsKey(b))
                map.put(b, new LinkedList<>());
            
            map.get(a).add(b);
            map.get(b).add(a);
        }

        Set<Integer> visited = new HashSet<>();
        int count = 0;

        for (int i : graph) {

            if (visited.contains(i))
                continue;
            
            this.visitSubGraph(i, map, visited);
            count++;
        }

        return count + n - graph.size();
    }

    private void visitSubGraph(int node, Map<Integer, List<Integer>> map, Set<Integer> visited) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(node);

        while (q.size() > 0) {
            int n = q.poll();
            if (visited.contains(n))
                continue;
            
            visited.add(n);

            List<Integer> connects = map.get(n);
            for (int i : connects) {

                if (!visited.contains(i))
                    q.offer(i);

            }
        }

    }
}