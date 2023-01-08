import java.util.*;

public class LC_0216_CombinationSumIII {
    
public List<List<Integer>> combinationSum3(int k, int n) {
        
    //int[] nums = new int[]{1,2,3,4,5,6,7,8,9};
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    int sum = 0;

    this.recur(1, n, sum, cur, res, k);
    return res;
}

private void recur(int index, int target, int sum, List<Integer> cur, List<List<Integer>> res, int k) {

    if (cur.size() == k) {
        if (sum == target) {
            List<Integer> ans = new ArrayList<>(cur);
            res.add(ans);
        }
        return;
    }

    if (sum >= target)
        return;
    
    for (int i=index; i<10; i++) {

        cur.add(i);
        this.recur(i+1, target, sum+i, cur, res, k);
        cur.remove(cur.size()-1);
    }

}
}