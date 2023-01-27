import java.util.*;

public class LC_0285_InorderSuccessorinBST_fast {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        TreeNode cur = root;
        TreeNode parent = null;
        Stack<TreeNode> stack = new Stack<>();

        while (cur != null) {

            if (cur == p) {
                if (cur.right != null) {
                    return getSmallest(cur.right);
                } else {
                    while (stack.size()>0) {
                        if (stack.peek().left == cur) {
                            System.out.println(stack.peek().val);
                            if (stack.peek().left != null)
                                System.out.println(stack.peek().left.val);
                            if (stack.peek().right != null)
                                System.out.println(stack.peek().right.val);
                            return stack.peek();
                        } else {
                            cur = stack.pop();
                        }
                    }
                    return null;
                }
            }

            parent = cur;
            stack.push(parent);

            if (cur.val > p.val) {
                cur = cur.left;
                continue;
            }

            if (cur.val < p.val) {
                cur = cur.right;
            }
        }

        return null;

    }

    private TreeNode getSmallest(TreeNode node) {
        while (node.left != null){
            node = node.left;
        }
        
        return node;
    }
}