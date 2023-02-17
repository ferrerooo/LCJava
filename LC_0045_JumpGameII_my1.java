public class LC_0045_JumpGameII_my1 {
    public int jump(int[] nums) {

        if(nums.length == 1)
            return 0;
            
        int farthest = nums[0];
        int cur = 1;
        int step = 1;

        while (farthest < nums.length-1) {
            
            int localfar = farthest;
            while (cur <= farthest) {
                localfar = Math.max(localfar, cur + nums[cur]);
                cur++;
            }
            farthest = localfar;
            step++;
            if (farthest >= nums.length-1)
                return step;
        }
        
        return step;
    }
}