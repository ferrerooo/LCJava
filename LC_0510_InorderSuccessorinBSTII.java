public class LC_0510_InorderSuccessorinBSTII {
    public Node inorderSuccessor(Node node) {
        
        if (node.right != null) {

            Node cur = node.right;
            while (cur.left != null)
                cur = cur.left;

            return cur;
        }

        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }

        if (node.parent == null)
            return null;
        
        return node.parent;

    }

    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };
}