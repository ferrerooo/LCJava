public class LC_0226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {

        if (root == null)
            return null;
        
        TreeNode l = this.invertTree(root.left);
        TreeNode r = this.invertTree(root.right);
        
        root.left = r;
        root.right = l;

        return root;
    }
}