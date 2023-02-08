public class LC_0213_HouseRobberII_my2 {
    public int rob(int[] nums) {

        if (nums.length == 1)
            return nums[0];
        
        int[] dp1 = new int[nums.length+1];
        int[] dp2 = new int[nums.length+1];

        dp1[0] = 0;
        dp1[1] = nums[0];
        dp1[2] = 0;

        for (int i = 3; i < dp1.length-1; i++) {
            dp1[i] = nums[i-1] + Math.max(dp1[i-2], dp1[i-3]);
        }

        dp2[0] = 0;
        dp2[1] = 0;
        dp2[2] = nums[1];

        for (int i=3; i<dp2.length; i++) {
            dp2[i] = nums[i-1] + Math.max(dp2[i-2], dp2[i-3]);
        }

        int res = 0;

        for (int i=0; i<dp1.length; i++) {
            res = Math.max(res, Math.max(dp1[i], dp2[i]));
        }

        return res;
    }
}