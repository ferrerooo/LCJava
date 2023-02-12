public class LC_0264_UglyNumberII_dp {
    
    public int nthUglyNumber(int n) {

        int[] dp = new int[n];
        dp[0] =1;

        int i2 = 0;
        int i3 = 0;
        int i5 = 0;

        for (int i=1; i<n; i++) {

            int num2 = dp[i2] * 2;
            int num3 = dp[i3] * 3;
            int num5 = dp[i5] * 5;

            int min = Math.min(Math.min(num2, num3), num5);
            dp[i] = min;

            if (num2 == min) {
                i2++;
            }

            if (num3 == min) {
                i3++;
            }

            if (num5 == min) {
                i5++;
            }
        }

        return dp[n-1];

    }
}