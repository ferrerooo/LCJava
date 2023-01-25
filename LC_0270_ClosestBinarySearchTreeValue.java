public class LC_0270_ClosestBinarySearchTreeValue {
    
    public int closestValue(TreeNode root, double target) {
        
        int res = -1;
        double diff = Double.MAX_VALUE;

        TreeNode cur = root;

        while (cur != null) {

            if (cur.val == target)
                return cur.val;

            if (Math.abs(cur.val - target) < diff) {
                diff = Math.abs(cur.val - target);
                res = cur.val;
            }

            if (cur.val > target) {
                cur = cur.left;
                continue;
            }

            if (cur.val < target) {
                cur = cur.right;
            }
        }

        return res;
    }
}