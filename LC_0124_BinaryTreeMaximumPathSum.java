public class LC_0124_BinaryTreeMaximumPathSum {
    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        this.getMaxSumPerNode(root);
        return res;
    }

    private int getMaxSumPerNode(TreeNode node) {

        int left = node.left == null ? 0 : this.getMaxSumPerNode(node.left);
        int right = node.right == null ? 0 : this.getMaxSumPerNode(node.right);

        int cur = node.val;      
        int localmax = Math.max(Math.max(cur, cur+left), Math.max(cur+right, cur+left+right));
        res = Math.max(res, localmax);

        return Math.max(cur, Math.max(cur+left, cur+right));
    }
}