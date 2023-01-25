public class LC_0700_SearchinaBinarySearchTree_dfs {
    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null)
            return null;
        
        if (root.val == val)
            return root;
        
        if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}