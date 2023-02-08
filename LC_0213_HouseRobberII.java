public class LC_0213_HouseRobberII {
    public int rob(int[] nums) {

        // 3 cases: 
        // No1 rob & NoN not rob
        // No1 not rob & NoN rob
        // No1 not rob & NoN not rob

        int n = nums.length;
        if (n == 1)
            return nums[0];
        if (n==2)
            return Math.max(nums[0], nums[1]);
        
        int[] dp1 = new int[n+1];
        int[] dp2 = new int[n+1];

        dp1[0] = 0;
        dp1[1] = nums[0];
        dp1[2] = 0;
        int max1 = dp1[1];
        for (int i=3; i<n; i++) {
            dp1[i] = nums[i-1] + Math.max(dp1[i-2], dp1[i-3]);
            max1 = Math.max(dp1[i], max1);
        }

        dp2[0] = 0;
        dp2[1] = 0;
        dp2[2] = nums[1];
        int max2 = dp2[2];
        for (int i=3; i<n+1; i++) {
            dp2[i] = nums[i-1] + Math.max(dp2[i-2], dp2[i-3]);
            max2 = Math.max(dp2[i], max2);
        }

        return Math.max(max1, max2);
    }
}