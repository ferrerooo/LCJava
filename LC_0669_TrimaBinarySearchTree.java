public class LC_0669_TrimaBinarySearchTree {
    public TreeNode trimBST(TreeNode root, int low, int high) {

        if (root == null)
            return null;
        
        if (root.left == null && root.right == null) {
            if (root.val < low || root.val > high) {
                return null;
            } else {
                return root;
            }
        }

        TreeNode l = trimBST(root.left, low, high);
        TreeNode r = trimBST(root.right, low, high);

        if (root.val < low || root.val > high) {
            if (l != null)
                return l;
            if (r != null)
                return r;
            return null;
        } else {
            root.left = l;
            root.right = r;
            return root;
        }
        
    }
}