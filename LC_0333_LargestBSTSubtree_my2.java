public class LC_0333_LargestBSTSubtree_my2 {
    
    private int largestSubTree = 0;

    public int largestBSTSubtree(TreeNode root) {
        
        dfs(root);
        return largestSubTree;
    }

    private int[] dfs(TreeNode node) {

        if (node == null) {
            // [0] min val [1] max val [2] node count [3] is BST or not
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 1}; 
        }

        int[] l = dfs(node.left);
        int[] r = dfs(node.right);

        if (l[3] == 0 || r[3] == 0) {
            return new int[]{0,0,0,0};
        }

        if (node.val <= l[1] || node.val >= r[0])
            return new int[]{0,0,0,0};
        
        int[] res = new int[4];
        if (l[0] == Integer.MAX_VALUE) {
            res[0] = node.val;
        } else {
            res[0] = l[0];
        }

        if (r[1] == Integer.MIN_VALUE) {
            res[1] = node.val;
        } else {
            res[1] = r[1];
        }

        res[2] = 1 + l[2] + r[2];
        res[3] = 1;

        largestSubTree = Math.max(largestSubTree, res[2]);

        return res;
    }
}