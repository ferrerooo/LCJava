import java.util.*;

public class LC_0040_CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        int curSum = 0;
        int index = 0;

        this.searchCombDfs(candidates, target, res, curList, curSum, index);
        return res;
    }

    private void searchCombDfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> curList, int curSum, int index) {

        if (curSum == target) {
            res.add(new ArrayList<Integer>(curList));
            return;
        }

        if (curSum > target)
            return;
        
        for (int i=index; i<candidates.length; i++) {

            if (i > index && candidates[i] == candidates[i-1])
                continue;

            curList.add(candidates[i]);
            this.searchCombDfs(candidates, target, res, curList, curSum+candidates[i], i+1);
            curList.remove(curList.size()-1);
        }

        return;
    }
}