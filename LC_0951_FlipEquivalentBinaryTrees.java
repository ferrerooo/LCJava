public class LC_0951_FlipEquivalentBinaryTrees {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {

        return isFlipEqual(root1, root2);
    }

    private boolean isFlipEqual(TreeNode node1, TreeNode node2) {

        if (node1 == null && node2 == null)
            return true;
        
        if ((node1==null && node2!=null) || (node1!=null&&node2==null) || (node1.val != node2.val))
            return false;
        
        return (this.isFlipEqual(node1.left, node2.left) && this.isFlipEqual(node1.right, node2.right)) || 
                (this.isFlipEqual(node1.left, node2.right) && this.isFlipEqual(node1.right, node2.left));

    }
}