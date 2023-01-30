import java.util.*;

public class LC_0051_N_Queens {

    public List<List<String>> solveNQueens(int n) {
        
        List<Integer> cur = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();

        dfs(n, cur, res);
        return res;
    }

    private void dfs(int n, List<Integer> cur, List<List<String>> res) {

        if (cur.size() == n) {

            List<String> sol = new ArrayList<>();
            for (int index : cur) {
                StringBuilder sb = new StringBuilder();
                for (int i=1; i<index; i++) 
                    sb.append(".");
                sb.append("Q");
                for (int i=index+1; i<=n; i++)
                    sb.append(".");
                sol.add(sb.toString());
            }
            res.add(sol);
            return;
        }

        for (int i=1; i<=n; i++) {
            if (isValid(n, cur, i)) {
                cur.add(i);
                dfs(n, cur, res);
                cur.remove(cur.size()-1);
            }
        }

        return;
    }

    private boolean isValid (int n, List<Integer> cur, int col) {

        int row = cur.size()+1;
        for (int i=0; i<cur.size(); i++) {
            
            int r = i+1;
            int c = cur.get(i);
            if (c == col)
                return false;
            
            if ((row+col) == (r+c))
                return false;

            if ((row-col) == (r-c))
                return false;
        }

        return true;
    }
}
