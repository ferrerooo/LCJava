public class LC_1335_MinimumDifficultyofaJobSchedule_my2 {
    public int minDifficulty(int[] jobDifficulty, int d) {

        if (d > jobDifficulty.length)
            return -1;
        
        int[][] dp = new int[d][jobDifficulty.length];

        for (int i=0; i<jobDifficulty.length; i++) {

            if (i == 0) {
                dp[0][0] = jobDifficulty[0];
                continue;
            }

            dp[0][i] = Math.max(jobDifficulty[i], dp[0][i-1]);

        }


        for (int i=1; i<d; i++) {
            for (int j=i; j<jobDifficulty.length; j++) {

                int localmax = jobDifficulty[j];
                dp[i][j] = localmax + dp[i-1][j-1];

                for (int k = j-1; k>=i; k--) {

                    localmax = Math.max(localmax, jobDifficulty[k]);
                    dp[i][j] = Math.min(dp[i][j], localmax + dp[i-1][k-1]);
                }


            }

        }

        /*for (int i=0; i<d; i++) {
            for (int j = 0; j<jobDifficulty.length; j++) {
                System.out.print(dp[i][j]+", ");
            }
            System.out.println();
        }*/

        return dp[d-1][jobDifficulty.length-1];
    }
}