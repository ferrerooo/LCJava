import java.util.*;

public class LC_1650_LowestCommonAncestorofaBinaryTreeIII {
    public Node lowestCommonAncestor(Node p, Node q) {
        
        Deque<Node> path1 = new LinkedList<>();
        Deque<Node> path2 = new LinkedList<>();

        Node p1 = p;
        Node q1 = q;

        while (p1 != null) {
            path1.offerFirst(p1);
            p1 = p1.parent;
        }

        while (q1 != null) {
            path2.offerFirst(q1);
            q1 = q1.parent;
        }

        Node res = null;

        while (path1.peek() == path2.peek()) {
            
            Node cur = path1.peek();
            path1.poll();
            path2.poll();

            if (cur == p || cur == q) {
                res = cur;
                break;
            }

            if (path1.peek() != path2.peek()) {
                res = cur;
                break;
            }
        }

        return res;

    }

    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };
}