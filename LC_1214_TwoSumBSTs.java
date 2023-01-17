import java.util.*;

public class LC_1214_TwoSumBSTs {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {

        List<Integer> list1 = getList(root1);
        List<Integer> list2 = getList(root2);
        
        Set<Integer> set = new HashSet<>();
        for (int i: list1) 
            set.add(i);

        for (int i: list2) {
            if (set.contains(target - i))
                return true;
        }

        return false;
    }

    private List<Integer> getList(TreeNode root) {

        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        while (cur != null || stack.size() > 0) {

            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }

        return list;

    }

    /*private List<Integer> getList(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        this.dfs(root, list);
        return list;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }*/
}