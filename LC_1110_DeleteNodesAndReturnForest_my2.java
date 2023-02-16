import java.util.*;

public class LC_1110_DeleteNodesAndReturnForest_my2 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        
        List<TreeNode> ans = new ArrayList<>();
        Set<Integer> del = new HashSet<>();

        for (int i:to_delete) {
            del.add(i);
        }

        TreeNode n = dfs(root, del, ans);

        if (n != null) {
            ans.add(n);
        }

        return ans;
    }

    private TreeNode dfs(TreeNode node, Set<Integer> del, List<TreeNode> ans) {

        if (node.left == null && node.right == null) {

            if (del.contains(node.val)) {
                return null;
            } else {
                return node;
            }
        }

        TreeNode l = null;
        TreeNode r = null;

        if (node.left != null) {
            l = dfs(node.left, del, ans);
        }

        if (node.right != null) {
            r = dfs(node.right, del, ans);
        }

        node.left = l;
        node.right = r;

        if (!del.contains(node.val)) {
            return node;
        } else {
            
            if (node.left != null)
                ans.add(node.left);

            if (node.right != null)
                ans.add(node.right);

            return null;
        }

    }
}