import java.util.*;

public class LC_0133_CloneGraph {
    public Node cloneGraph(Node node) {

        if (node == null)
            return null;

        Queue<Node> q = new LinkedList<>();
        Map<Integer, Node> map = new HashMap<>();
        q.offer(node);
        Set<Node> visited = new HashSet<>();

        while (q.size() >0) {

            Node n = q.poll();

            if (visited.contains(n))
                continue;

            if (!map.containsKey(n.val)) {
                map.put(n.val, new Node(n.val));
            }
            visited.add(n);

            List<Node> connects = n.neighbors;
            for (Node nb : connects) {
                if (!map.containsKey(nb.val))
                    map.put(nb.val, new Node(nb.val));
                map.get(n.val).neighbors.add(map.get(nb.val));
                if (!visited.contains(nb))
                    q.offer(nb);
            }
        }

        return map.get(node.val);
    }

    private class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}