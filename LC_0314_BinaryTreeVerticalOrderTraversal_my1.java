import java.util.*;

public class LC_0314_BinaryTreeVerticalOrderTraversal_my1 {
    
    public List<List<Integer>> verticalOrder(TreeNode root) {

        Queue<TreeNodeWithIndex> current = new LinkedList<>();
        Queue<TreeNodeWithIndex> next = new LinkedList<>();

        if (root == null)
            return new LinkedList<>();

        List<List<int[]>> layers = new LinkedList<>();
        current.offer(new TreeNodeWithIndex(root, 0));

        while (current.size() > 0) {

            List<int[]> layer = new LinkedList<>();

            while (current.size() > 0) {
                
                TreeNodeWithIndex ni = current.poll();
                
                layer.add(new int[]{ni.node.val, ni.index});

                if (ni.node.left != null) {
                    next.offer(new TreeNodeWithIndex(ni.node.left, ni.index-1));
                }

                if (ni.node.right != null) {
                    next.offer(new TreeNodeWithIndex(ni.node.right, ni.index+1));
                }
            }

            layers.add(layer);
            current = next;
            next = new LinkedList<>();
        }

        int minIndex = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (List<int[]> layer : layers) {

            for (int[] pair : layer) {
                minIndex = Math.min(minIndex, pair[1]);
                if (!map.containsKey(pair[1]))
                    map.put(pair[1], new LinkedList<Integer>());
                
                map.get(pair[1]).add(pair[0]);
            }
        }

        List<List<Integer>> result = new LinkedList<>();
        int curCol = minIndex;
        while (map.containsKey(curCol)) {
            result.add(map.get(curCol));
            curCol++;
        }

        return result;
    }

    class TreeNodeWithIndex {
        public TreeNode node;
        public Integer index;
        public TreeNodeWithIndex(TreeNode n, Integer i) {
            this.node = n;
            this.index = i;
        }
    }
}