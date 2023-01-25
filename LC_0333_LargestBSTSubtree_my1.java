public class LC_0333_LargestBSTSubtree_my1 {
    
    int res = 0;

    public int largestBSTSubtree(TreeNode root) {
        
        if (root == null)
            return 0;
        
        int[] l = recur(root.left);  // array length is always 4, [0]: 1 is BST, 0 not BST; [1] subtree count; [2] minval [3] maxval
        int[] r = recur(root.right);

        if (l[0] == 1 && r[0] == 1 && (l[1] == 0 || l[3] < root.val) && (r[1] == 0 || r[2] > root.val)) {
            res = Math.max(res, 1 + l[1] + r[1]);
        }

        return res;
    }

    private int[] recur(TreeNode node) {

        if (node == null) {
            return new int[]{1, 0, Integer.MIN_VALUE, Integer.MAX_VALUE};
        }

        if (node.left == null && node.right == null) {
            res = Math.max(res, 1);
            return new int[]{1, 1, node.val, node.val};
        }

        int[] l = recur(node.left); 
        int[] r = recur(node.right);

        if (l[0] == 1 && r[0] == 1 && (l[1] == 0 || l[3] < node.val) && (r[1] == 0 || r[2] > node.val)) {
            res = Math.max(res, 1 + l[1] + r[1]);
            return new int[]{1, 1+l[1]+r[1], l[1]==0?node.val:l[2], r[1]==0?node.val:r[3]};
        } else {
            return new int[]{0, 1+l[1]+r[1], 0, 0};
        }
    }
}