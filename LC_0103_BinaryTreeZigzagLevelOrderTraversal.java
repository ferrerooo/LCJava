import java.util.*;

public class LC_0103_BinaryTreeZigzagLevelOrderTraversal {
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> results = new LinkedList<>();

        Deque<TreeNode> current = new LinkedList<>();
        Deque<TreeNode> next = new LinkedList<>();

        if (root == null)
            return results;
        
        current.add(root);
        boolean isLeftToRight = true;

        while (current.size() > 0) {

            List<Integer> layer = new LinkedList<>();

            while (current.size() > 0) {
                if (isLeftToRight) {
                    TreeNode n = current.pollFirst();
                    layer.add(n.val);
                    if (n.left != null)
                        next.offerLast(n.left);
                    if (n.right != null)
                        next.offerLast(n.right);
                } else {
                    TreeNode n = current.pollLast();
                    layer.add(n.val);
                    if (n.right != null)
                        next.offerFirst(n.right);
                    if (n.left != null)
                        next.offerFirst(n.left);
                }
            }

            results.add(layer);
            current = next;
            next = new LinkedList<>();
            isLeftToRight = !isLeftToRight;   
        }

        return results;
    }
}