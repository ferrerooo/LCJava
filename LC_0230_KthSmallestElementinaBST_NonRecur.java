import java.util.*;

public class LC_0230_KthSmallestElementinaBST_NonRecur {
    public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        //stack.push(root);
        int index = 0;
        int res = 0;

        while (cur != null || stack.size() > 0) {

            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                index++;
                if (index == k) {
                    res = cur.val;
                    break;
                }
                cur = cur.right;
            }

        }

        return res;
    }
}