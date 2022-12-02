import java.util.*;
import javafx.util.Pair;

public class LC_2096_DirectionsFromaBinaryTreeNodetoAnother {
    
    public String getDirections(TreeNode root, int startValue, int destValue) {
        
        var q1 = getPath(root, startValue);
        var q2 = getPath(root, destValue);
        
        while (!q1.isEmpty() 
               && !q2.isEmpty() 
               && q1.peek().getKey() == q2.peek().getKey()) {
            q1.remove();
            q2.remove();
        }
        
        var path = new StringBuilder();
        
        while(!q1.isEmpty()) {
            q1.remove();
            path.append("U");
        }
        
        while (!q2.isEmpty()) {
            var n = q2.poll();
            path.append(n.getValue());
        }
        
        return path.toString();
    }
    
    private static Queue<Pair<TreeNode, String>> getPath(TreeNode root, int target) {
        
        var list = new LinkedList<Pair<TreeNode, String>>();
        list.offer(new Pair<TreeNode, String>(root, ""));
        recur(list, target);
        return list;
    }
    
    private static boolean recur(LinkedList<Pair<TreeNode, String>> list, int target) {
        
        var node = list.peekLast().getKey();
        if (node.val == target)
            return true;
        
        if (node.left != null) {
            list.offer(new Pair<TreeNode, String>(node.left, "L"));
            var findTarget = recur(list, target);
            if (findTarget)
                return true;
            else
                list.removeLast();
        }
        
        if (node.right != null) {
            list.offer(new Pair<TreeNode, String>(node.right, "R"));
            var findTarget = recur(list, target);
            if (findTarget)
                return true;
            else
                list.removeLast();
        }
        
        return false;
    } 

}
