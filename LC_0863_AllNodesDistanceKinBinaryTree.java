import java.util.*;

public class LC_0863_AllNodesDistanceKinBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        List<Integer> res = new ArrayList<>();

        //if (k == 0) {
        //    res.add(target.val);
        //    return res;
        //}

        this.dis(root, target, k, res);
        return res;
    }

    private int dis(TreeNode node, TreeNode target, int k, List<Integer> res) {

        if (node == null)
            return -1;
        
        if (node == target) {
            this.collect(node, k, res);
            return 0;
        }

        int disLeft = this.dis(node.left, target, k, res);
        int disRight = this.dis(node.right, target, k, res);

        if (disLeft >=0) {
            if (disLeft +1 == k) {
                res.add(node.val);
            }
            this.collect(node.right, k-disLeft-2, res);
            return disLeft+1;
        }

        if (disRight >=0) {
            if (disRight + 1 == k) {
                res.add(node.val);
            }
            this.collect(node.left, k-disRight-2, res);
            return disRight+1;
        }
        
        return -1;
    }

    private void collect(TreeNode node, int k, List<Integer> res) {

        if (k<0 || node == null)
            return;
        
        if (k == 0) {
            res.add(node.val);
            return;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        for (int i=0; i<k && queue.size() > 0; i++) {

            LinkedList<TreeNode> temp = new LinkedList<>();
            while (queue.size() > 0) {
                TreeNode cur = queue.poll();
                if (cur.left != null)
                    temp.offer(cur.left);
                if (cur.right != null)
                    temp.offer(cur.right);
            }
            queue = temp;
        }

        while (queue.size() > 0) 
            res.add(queue.poll().val);
    }
}