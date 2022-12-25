public class LC_0236_LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if (root == null)
            return null;
        
        if (root == p)
            return p;
        
        if (root == q)
            return q;
        
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        if (l!= null && r!=null)
            return root;
        
        if (l!= null)
            return l;
        else
            return r;

    }
}