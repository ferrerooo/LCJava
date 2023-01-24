import java.util.*;

public class LC_1644_LowestCommonAncestorofaBinaryTree_II_my1 {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        Deque<TreeNode> deq1 = new LinkedList<>();
        Deque<TreeNode> deq2 = new LinkedList<>();

        boolean haspath1 = this.hasPath(root, p, deq1);
        boolean haspath2 = this.hasPath(root, q, deq2);

        if (!haspath1 || !haspath2)
            return null;

        TreeNode res = null;

        while (deq1.peekFirst() == deq2.peekFirst()) {

            TreeNode n = deq1.pollFirst();
            deq2.pollFirst();

            if (n == q || n == p) {
                res = n;
                break;
            }

            if (deq1.peekFirst() != deq2.peekFirst())  {
                res = n;
                break;
            }
        }

        return res;
    }

    private boolean hasPath(TreeNode node, TreeNode p, Deque<TreeNode> deq) {

        if (node == null)
            return false;
        
        deq.offer(node);

        if (p == node)
            return true;
        
        boolean inL = hasPath(node.left, p, deq);
        if (inL)
            return true;
        
        boolean inR = hasPath(node.right, p, deq);
        if (inR)
            return true;
        
        deq.pollLast();
        return false;
    }
}