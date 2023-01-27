import java.util.*;

public class LC_0285_InorderSuccessorinBST_NoRecur_Slow {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        TreeNode res = null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        boolean flag = false;

        while (cur != null || stack.size() > 0) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (flag) {
                    res = cur;
                    break;
                }

                if (cur.val == p.val) {
                    flag = true;
                }

                cur = cur.right;
            }
        }
        
        return res;
    }
}