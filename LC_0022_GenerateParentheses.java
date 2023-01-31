import java.util.*;

public class LC_0022_GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        
        String cur = "";
        List<String> res = new ArrayList<>();
        int left = n;
        int right = n;

        dfs(left, right, cur, res);

        return res;
    }

    private void dfs(int left, int right, String cur, List<String> res) {

        if (left == 0 && right == 0) {
            res.add(cur);
            return;
        }

        if (left == right) {
            dfs(left-1, right, cur+"(", res);
        } else if (left < right) {
            if (left != 0) {
                dfs(left-1, right, cur+"(", res);
            }
            dfs(left, right-1, cur+")", res);
        } else {
            // not possible
        }

    }
}