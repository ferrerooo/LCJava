import java.util.*;

public class LC_0102_BinaryTreeLevelOrderTraversal {
    
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> results = new LinkedList<>();

        Queue<TreeNode> current = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();

        if (root == null)
            return results;
        
        current.offer(root);

        while (current.size() > 0) {
            List<Integer> layer = new LinkedList<>();
            while (current.size()>0) {
                TreeNode node = current.poll();
                layer.add(node.val);
                if (node.left != null)
                    next.offer(node.left);
                if (node.right != null)
                    next.offer(node.right);
            }

            results.add(layer);
            current = next;
            next = new LinkedList<>();
        }
        
        return results;
    }
}