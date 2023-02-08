import java.util.*;

public class LC_0098_ValidateBinarySearchTree {
    
    public boolean isValidBST(TreeNode root) {

        TreeNode cur = root;
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();

        while (cur != null || stack.size() > 0) {

            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (pre == null) {
                    pre = cur;
                } else {
                    if (pre.val >= cur.val) 
                        return false;
                    else
                        pre = cur;
                }

                cur = cur.right;
            }
        }

        return true;
        
    }
}