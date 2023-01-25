public class LC_0230_KthSmallestElementinaBST_recur {
    private int res = -1;
    private int cnt = 0;

    public int kthSmallest(TreeNode root, int k) {
        
        this.dfs(root, k);
        return res;
    }

    private void dfs(TreeNode node, int k) {

        if (node == null) {
            return ;
        }

        dfs(node.left, k);
        cnt ++;
        
        if (cnt == k) {
            res = node.val;
            return;
        }

        if (cnt > k) {
            return;
        }

        dfs(node.right, k);
    }
}