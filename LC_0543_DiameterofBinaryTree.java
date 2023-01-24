public class LC_0543_DiameterofBinaryTree {
    private int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        
        this.recur(root);

        return res;
    }

    private int recur(TreeNode node) {

        int left = node.left == null? 0 : this.recur(node.left) + 1;
        int right = node.right == null ? 0 : this.recur(node.right) + 1;

        res = Math.max(left+right, res);
        return Math.max(left, right);
    }
}