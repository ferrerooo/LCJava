public class LC_0486_PredicttheWinner_minmax {
    public boolean PredictTheWinner(int[] nums) {

        return this.score(nums, 0, nums.length-1) >=0 ;
    }

    private int score(int[] nums, int p1, int p2) {

        if(p1 == p2) {
            return nums[p1];
        }

        return Math.max(nums[p1]-score(nums, p1+1, p2), nums[p2]-score(nums, p1, p2-1));

    }
}