public class LC_0926_FlipStringtoMonotoneIncreasing {
    public int minFlipsMonoIncr(String s) {
        
        int currentOneCount = 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 0;

        for (int i=1; i<s.length()+1; i++) {

            if (s.charAt(i-1) == '0') {
                dp[i] = Math.min(currentOneCount, 1+dp[i-1]);
            } else {
                dp[i] = dp[i-1];
                currentOneCount++;
            }
        }

        return dp[s.length()];
    }
}