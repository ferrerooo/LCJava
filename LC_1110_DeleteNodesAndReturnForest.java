import java.util.*;

public class LC_1110_DeleteNodesAndReturnForest {
    
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        
        Set<Integer> del = new HashSet<>();
        for (int i:to_delete) {
            del.add(i);
        }

        List<TreeNode> res = new ArrayList<>();

        TreeNode n = this.dfs(root, del, res);

        if (n != null) {
            res.add(n);
        }

        return res;
    }

    private TreeNode dfs(TreeNode node, Set<Integer> del, List<TreeNode> res) {

        if (node == null)
            return null;
        
        if (node.left == null && node.right == null) {
            if (del.contains(node.val)) {
                return null;
            } else {
                return node;
            }
        }

        node.left = dfs(node.left, del, res);
        node.right = dfs(node.right, del, res);

        if (del.contains(node.val)) {
            if (node.left != null) res.add(node.left);
            if (node.right != null) res.add(node.right);
            return null;
        } else {
            return node;
        }
    }
}