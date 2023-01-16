import java.util.*;

public class LC_0526_BeautifulArrangement_2nd {
    private int res = 0;

    public int countArrangement(int n) {
        
        List<Integer> cur = new ArrayList<>();
        //int index = 1;
        boolean[] visited = new boolean[n+1];
        this.dfs(n, cur, visited);
        return res;
    }

    private void dfs(int n, List<Integer> cur, boolean[] visited) {

        if (cur.size() == n) {
            /*for (int i:cur) {
                System.out.print(i+", ");
            }
            System.out.println();*/
            res++;
            return;
        }

        for (int i=1; i<=n; i++) {

            if (visited[i])
                continue;
            
            visited[i] = true;
            cur.add(i);

            if (cur.size() % cur.get(cur.size()-1) == 0 || cur.get(cur.size()-1) % cur.size() == 0) {
                //System.out.println("Good case : i:"+i+", cur.get(cur.size()-1):"+cur.get(cur.size()-1));
                this.dfs(n, cur, visited);
            } else {
                //System.out.println("Bad case : i:"+i+", cur.get(cur.size()-1):"+cur.get(cur.size()-1));
            }

            visited[i] = false;
            cur.remove(cur.size()-1);
        }
    }
}