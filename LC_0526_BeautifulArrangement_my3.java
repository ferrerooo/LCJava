import java.util.*;

public class LC_0526_BeautifulArrangement_my3 {
    private int res = 0;
    public int countArrangement(int n) {
        
        List<Integer> cur = new ArrayList<>();
        boolean[] visited = new boolean[n+1];
        dfs(n, cur, visited);
        return res;
    }

    private void dfs(int n, List<Integer> cur, boolean[] visited) {

        if (cur.size() == n) {
            res++;
            return;
        }

        for (int i=1; i<=n; i++) {

            if (visited[i]) {
                continue;
            }

            if ((i % (cur.size()+1) == 0) || ((cur.size()+1) % i == 0)) {
                visited[i] = true;
                cur.add(i);
                dfs(n, cur, visited);
                visited[i] = false;
                cur.remove(cur.size()-1);
            }

        }

    }
}