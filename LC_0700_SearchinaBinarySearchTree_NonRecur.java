import java.util.*;

public class LC_0700_SearchinaBinarySearchTree_NonRecur {

    public TreeNode searchBST(TreeNode root, int val) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || stack.size() > 0) {

            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (cur.val == val) {
                    return cur;
                }
                cur = cur.right;
            }

        }
        
        return null;
    }
}
