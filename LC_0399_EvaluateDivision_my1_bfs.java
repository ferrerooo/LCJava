import java.util.*;

public class LC_0399_EvaluateDivision_my1_bfs {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        Map<String, Map<String, Double>> map = new HashMap<>();

        for (int i=0; i<equations.size(); i++) {
            List<String> list = equations.get(i);
            double v = values[i];
            String x = list.get(0);
            String y = list.get(1);

            map.putIfAbsent(x, new HashMap<>());
            map.get(x).put(y, v);
            map.putIfAbsent(y, new HashMap<>());
            map.get(y).put(x, 1/v);
        }

        double[] res = new double[queries.size()];

        for (int i=0; i<queries.size(); i++) {
            res[i] = calculate(queries.get(i), map);
        }

        return res;
    }

    private double calculate(List<String> q, Map<String, Map<String, Double>> map) {

        String start = q.get(0);
        String end = q.get(1);

        if (start.equals(end) && map.containsKey(start))
            return 1.0;

        Set<Node> cur = new HashSet<>();
        Set<Node> next = new HashSet<>();
        Set<String> visited = new HashSet<>();
        Node n = new Node(start, 1.0);
        visited.add(start);
        cur.add(n);

        while (cur.size() > 0) {

            for (Node curnode : cur) {
                if (!map.containsKey(curnode.s)) {
                    return -1;
                }

                Map<String, Double> submap = map.get(curnode.s);
                for (Map.Entry<String, Double> entry : submap.entrySet()) {
                    if (visited.contains(entry.getKey())) {
                        continue;
                    } else {
                        visited.add(entry.getKey());
                        Node newnode = new Node(entry.getKey(), curnode.d*entry.getValue());
                        next.add(newnode);
                        if (newnode.s.equals(end)) {
                            return newnode.d;
                        }
                    }
                }
            }

            cur = next;
            next = new HashSet<Node>();

        }

        return -1.0;
    }

    private class Node {
        String s;
        double d;
        Node(String _s, double _d) {
            s = _s;
            d = _d;
        }
    }
}