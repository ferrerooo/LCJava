import java.util.*;

public class LC_0987_VerticalOrderTraversalofaBinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<int[]> lists = new ArrayList<>();
        recur(root, 0, 0, lists);

        Collections.sort(lists, (x,y)-> {
            if (x[2]!=y[2]) {
                return x[2]-y[2];
            } else if (x[1]!= y[1]) {
                return x[1]-y[1];
            } else {
                return x[0]-y[0];
            }
        });

        List<List<Integer>> res = new ArrayList<>();

        int index = 0;
        while (index < lists.size()) {

            int curCol = lists.get(index)[2];
            List<Integer> list = new ArrayList<>();
            while (index<lists.size() && lists.get(index)[2] == curCol) {
                list.add(lists.get(index)[0]);
                index++;
            }
            res.add(list);
        }
        
        return res;
    }

    private void recur(TreeNode node, int row, int col, List<int[]> lists) {

        if (node == null)
            return;
        
        lists.add(new int[]{node.val, row, col});

        recur(node.left, row+1, col-1, lists);
        recur(node.right, row+1, col+1, lists);

    }
}