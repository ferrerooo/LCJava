import java.util.*;

public class LC_0077_Combinations {
    public List<List<Integer>> combine(int n, int k) {

        //int[] nums = new int[n];
        //for (int i=0; i<n; i++) {
        //    nums[i] = i+1;
        //}

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        this.dfs(1, cur, res, k, n);
        return res;
    }

    private void dfs(int index, List<Integer> cur, List<List<Integer>> res, int k, int n) {

        if (cur.size() == k) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }

        for (int i=index; i<=n; i++) {

            cur.add(i);
            this.dfs(i+1, cur, res, k, n);
            cur.remove(cur.size()-1);
        }

    }
}