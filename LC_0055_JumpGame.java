public class LC_0055_JumpGame {
    public boolean canJump(int[] nums) {

        int farthest = 0;
        int cur = 0;

        while (cur <= farthest) {

            farthest = Math.max(farthest, nums[cur] + cur);
            if (farthest >= nums.length-1) {
                return true;
            }
            cur ++;
        }

        return false;
        
    }
}