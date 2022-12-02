import java.util.*;

public class LC_2096_DirectionsFromaBinaryTreeNodetoAnother_2 {

    public String getDirections(TreeNode root, int startValue, int destValue) {
    
        StringBuilder sb = new StringBuilder();
        
        LinkedList<String[]> sPath = new LinkedList<>();
        LinkedList<String[]> dPath = new LinkedList<>();
        
        this.getPath(root, startValue, sPath);
        this.getPath(root, destValue, dPath);
        
        String[] sPre = null;
        String[] dPre = null;
        
        while (sPath.size() > 0 && dPath.size() > 0 && sPath.peekFirst()[0].equals(dPath.peekFirst()[0])) {
            sPre = sPath.peekFirst();
            dPre = dPath.peekFirst();
            sPath.removeFirst();
            dPath.removeFirst();
        }
        
        while (sPath.size() > 0) {
            sb.append("U");
            sPath.removeFirst();
        }
        
        sb.append(dPre[1]);
        
        while (dPath.size() > 0) {
            sb.append(dPath.peekFirst()[1]);
            dPath.removeFirst();
        }
        
        return sb.toString();
    }
    
    private boolean getPath(TreeNode root, int value, LinkedList<String[]> path) {
        
        if (root == null)
            return false;
        
        if (root.val == value) {
            path.addFirst(new String[]{String.valueOf(root.val), ""});
            return true;
        }
        
        if (this.getPath(root.left, value, path)) {
            path.addFirst(new String[]{String.valueOf(root.val), "L"});
            return true;
        }
        
        if (this.getPath(root.right, value, path)) {
            path.addFirst(new String[]{String.valueOf(root.val), "R"});
            return true;
        }
        
        return false;
    }
    
}
