public class LC_0572_SubtreeofAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null)
            return false;
        
        if (isEqual(root, subRoot))
            return true;
        
        if (isSubtree(root.left, subRoot))
            return true;
        
        if (isSubtree(root.right, subRoot))
            return true;
        
        return false;
    }

    private boolean isEqual(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null)
            return true;
        
        if ((root1 != null && root2 == null) || (root1 ==null && root2 != null) )
            return false;
        
        if (root1.val != root2.val)
            return false;
        
        return isEqual(root1.left, root2.left) && isEqual(root1.right, root2.right);

    }
}