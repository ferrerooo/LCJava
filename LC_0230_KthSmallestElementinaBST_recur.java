public class LC_0230_KthSmallestElementinaBST_recur {
    private int res = 0;
    private int index = 0;

    public int kthSmallest(TreeNode root, int k) {

        this.recur(root, k);
        return res;
    }

    private void recur(TreeNode node, int k) {

        if (node == null)
            return ;
        
        recur(node.left,k);
        index++;
        if (index == k) {
            res = node.val;
            return;
        }
        recur(node.right,k);

    }
}