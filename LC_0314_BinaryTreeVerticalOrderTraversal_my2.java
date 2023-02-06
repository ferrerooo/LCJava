import java.util.*;

public class LC_0314_BinaryTreeVerticalOrderTraversal_my2 {
    
    public List<List<Integer>> verticalOrder(TreeNode root) {

        Map<Integer, List<int[]>> map = new HashMap<>();

        dfs(root, map, 0, 0);
        
        int col = getMinCol(map);

        List<List<Integer>> res = new ArrayList<>();

        while (map.containsKey(col)) {
            
            List<int[]> list = map.get(col);
            Collections.sort(list, (x,y)->x[0]-y[0]);
            List<Integer> cur = new ArrayList<>();
            for (int[] pair : list) {
                cur.add(pair[1]);
            }
            res.add(new ArrayList<>(cur));
            col++;
        }

        return res;
    }

    private int getMinCol(Map<Integer, List<int[]>> map) {
        int min = Integer.MAX_VALUE;

        for (int i : map.keySet()) {
            min = Math.min(min, i);
        }

        return min;
    }

    private void dfs(TreeNode node, Map<Integer, List<int[]>> map, int col, int row) {

        if (node == null) {
            return;
        }

        map.putIfAbsent(col, new ArrayList<>());
        map.get(col).add(new int[]{row, node.val});

        dfs(node.left, map, col-1, row+1);
        dfs(node.right, map, col+1, row+1);
    }
}