import java.util.*;

public class LC_0133_CloneGraph_my2 {
    
    public Node cloneGraph(Node node) {

        if (node == null)
            return null;

        Map<Node, Node> map = new HashMap<>();

        LinkedList<Node> list = new LinkedList<>();
        list.add(node);

        Set<Node> visited = new HashSet<>();

        while (list.size() > 0) {

            Node cur = list.poll();

            if (visited.contains(cur)) {
                continue;
            }

            map.putIfAbsent(cur, new Node(cur.val));

            for (Node n : cur.neighbors) {
                map.putIfAbsent(n, new Node(n.val));
                map.get(cur).neighbors.add(map.get(n));
                if (!visited.contains(n)) {
                    list.add(n);
                }
            }

            visited.add(cur);
        }
        
        return map.get(node);

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