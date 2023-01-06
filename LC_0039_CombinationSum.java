import java.util.*;

public class LC_0039_CombinationSum {
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        int curSum = 0;
        List<Integer> curList = new ArrayList<>();
        int index = 0;

        this.searchCombDfs(candidates, target, res, curList, curSum, index);
        return res;
    }

    private void searchCombDfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> curList, int curSum, int index) {

        if (curSum == target) {
            res.add(new ArrayList<Integer>(curList));
            return;
        }

        if (curSum > target) {
            return;
        }

        for (int i=index; i<candidates.length; i++) {

            curList.add(candidates[i]);
            this.searchCombDfs(candidates, target, res, curList, curSum+candidates[i], i);
            curList.remove(curList.size()-1);
        }

        return;

    }
}