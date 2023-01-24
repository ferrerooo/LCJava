public class LC_1644_LowestCommonAncestorofaBinaryTreeII_standardSolution {
    private boolean bothExist = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        TreeNode node = this.dfs(root, p, q);

        if (bothExist)
            return node;
        
        if (isInTree(node, p) && isInTree(node, q))
            return node;
        else
            return null;
    }

    private TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null)
            return null;
        
        if (node == p || node == q)
            return node;
        
        TreeNode l = dfs(node.left, p, q);
        TreeNode r = dfs(node.right, p, q);

        if (l != null && r != null) {
            bothExist = true;
            return node;
        }

        if (l!=null)
            return l;
        
        if (r != null)
            return r;
        
        return null;
    }

    private boolean isInTree(TreeNode root, TreeNode n) {

        if (root == null)
            return false;
        
        if (root == n)
            return true;
        
        if (isInTree(root.left, n) || isInTree(root.right, n))
            return true;
        else
            return false;
    }
}