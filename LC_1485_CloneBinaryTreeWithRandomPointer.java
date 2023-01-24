import java.util.*;

public class LC_1485_CloneBinaryTreeWithRandomPointer {
    public NodeCopy copyRandomBinaryTree(Node root) {
        
        Map<Node, NodeCopy> map = new HashMap<>();
        return this.dfs(root, map);
    }

    private NodeCopy dfs (Node node, Map<Node, NodeCopy> map) {

        if (node == null)
            return null;

        if (!map.containsKey(node)) {
            NodeCopy nc = new NodeCopy();
            nc.val = node.val;
            map.put(node, nc);
        }

        if (node.random == null)
            map.get(node).random = null;
        else {
            if (!map.containsKey(node.random)) {
                NodeCopy randomNode = new NodeCopy();
                randomNode.val = node.random.val;
                map.put(node.random, randomNode);
            }
            //map.get(node).random = map.get(node.random);
        }

        //map.get(node).left = dfs(node.left, map);
        //map.get(node).right = dfs(node.right, map);

        return map.get(node);
    }

    private class NodeCopy {
             int val;
             Node left;
             Node right;
             Node random;
             NodeCopy() {}
             
         }


         private class Node {
            int val;
            Node left;
            Node right;
            Node random;
            Node() {}
        }
}