import java.util.*;

public class LC_1110_DeleteNodesAndReturnForest_DFS_MyOwnWay {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        

        List<TreeNode> res = new ArrayList<>();
        Set<Integer> del = new HashSet<>();
        for (int d:to_delete)
            del.add(d);
        
        TreeNode n = recur(root, res, del);

        if (n!=null)
            res.add(n);
        
        return res;
    }

    private TreeNode recur(TreeNode node, List<TreeNode> res, Set<Integer> del) {

        if (node == null)
            return null;
        
        node.left = recur(node.left, res, del);
        node.right = recur(node.right, res, del);

        if (del.contains(node.val)) {
            if (node.left != null)
                res.add(node.left);
            if (node.right != null)
                res.add(node.right);
            return null;
        }

        return node;
    }
        /*
        Map<Integer, TreeNode[]> map = new HashMap<>();
        map.put(root.val, new TreeNode[]{root, null});
        this.fillInMap(root, map);
        
        Set<Integer> set = new HashSet<>();
        set.add(root.val);

        for (int del : to_delete) {

            if (set.contains(del)) {
                set.remove(del);
            }

            TreeNode cur = map.get(del)[0];
            TreeNode parent = map.get(del)[1];

            if (parent != null) {
                if (parent.left == cur)
                    parent.left = null;
                if (parent.right == cur)
                    parent.right = null;
            }
            
            
            if (cur.left != null)
                set.add(cur.left.val);
            
            if (cur.right != null)
                set.add(cur.right.val);
        }

        List<TreeNode> res = new ArrayList<>();
        for (int n : set) {
            res.add(map.get(n)[0]);
        }

        return res;
    }

    private void fillInMap(TreeNode node, Map<Integer, TreeNode[]> map) {

        if (node == null)
            return ;

        if (node.left != null) {
            map.put(node.left.val, new TreeNode[]{node.left, node});
            fillInMap(node.left, map);
        }

        if (node.right != null) {
            map.put(node.right.val, new TreeNode[]{node.right, node});
            fillInMap(node.right, map);
        }

    }
    */
}
