import java.util.*;

public class LC_1676_LowestCommonAncestorofaBinaryTreeIV {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {

        Set<TreeNode> set = new HashSet<>();
        for (TreeNode node : nodes)
            set.add(node);
        
        return this.lca(root, set);
    }

    private TreeNode lca(TreeNode node, Set<TreeNode> set) {

        if (node == null)
            return null;
        
        if (set.contains(node))
            return node;
        
        TreeNode l = this.lca(node.left, set);
        TreeNode r = this.lca(node.right, set);

        if (l != null && r != null)
            return node;
        
        if (l == null)
            return r;

        return l;

    }
}