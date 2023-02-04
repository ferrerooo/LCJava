public class LC_1335_MinimumDifficultyofaJobSchedule {
    public int minDifficulty(int[] jobDifficulty, int d) {

        int[] jobs = jobDifficulty;

        int len = jobs.length;

        if (d > len)
            return -1;

        int[][] dp = new int[d][len];

        dp[0][0] = jobs[0];

        for (int i=1; i<len; i++) {
            dp[0][i] = Math.max(jobs[i], dp[0][i-1]);
        }

        for (int i=1; i<d; i++) {

            for (int j=i; j<len; j++) {

                int last = jobs[j];
                int localmin = jobs[j] + dp[i-1][j-1];
                for (int k=j-1; k>=i; k--) {
                    last = Math.max(last, jobs[k]);
                    localmin = Math.min(localmin, last + dp[i-1][k-1]);
                }

                dp[i][j] = localmin;
            }

        }

        //if (dp[d-1][len-1] == 0)
        //    return -1;
        return dp[d-1][len-1];
        
    }
}