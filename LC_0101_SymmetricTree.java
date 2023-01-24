public class LC_0101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {

        return this.isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode node1, TreeNode node2) {

        if (node1 == null && node2 == null)
            return true;
        
        if ((node1==null && node2!=null) || (node1!=null && node2==null) || (node1.val != node2.val) )
            return false;
        
        if (!isMirror(node1.left, node2.right))
            return false;

        if (!isMirror(node1.right, node2.left))
            return false;
        
        return true;
    }
}