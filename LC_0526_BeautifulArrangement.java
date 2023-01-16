import java.util.*;

public class LC_0526_BeautifulArrangement {
    private int res = 0;
    
    public int countArrangement(int n) {

        int[] nums = new int[n+1];
        for (int i=0; i<nums.length; i++)
            nums[i] = i;

        List<Integer> cur = new ArrayList<>();
        cur.add(0);
        boolean[] visited = new boolean[n+1];

        this.dfs(nums, n, cur, visited);
        return res;
    }

    private void dfs(int[] nums, int n, List<Integer> cur, boolean[] visited) {

        if (cur.size() == n+1) {
            res++;
            return;
        }

        for (int i=1; i<=n; i++) {
            
            if (visited[i]) {
                continue;
            }

            if ( cur.size()%nums[i] == 0 || nums[i]%cur.size()==0) {
                visited[i] = true;
                cur.add(nums[i]);
                this.dfs(nums, n, cur, visited);
                visited[i] = false;
                cur.remove(cur.size()-1);
            }

        }

    }
}