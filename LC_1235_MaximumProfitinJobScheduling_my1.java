import java.util.*;

public class LC_1235_MaximumProfitinJobScheduling_my1 {

    // timeout solution

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        List<int[]> list = new ArrayList<>();
        for (int i=0; i<startTime.length; i++) {
            int[] arr = new int[3];
            arr[0] = endTime[i];
            arr[1] = startTime[i];
            arr[2] = profit[i];
            list.add(arr);
        }

        Collections.sort(list, (x,y)-> x[0]-y[0]);

        int[] dp = new int[list.get(list.size()-1)[0]+1];

        int p = 1;

        while (p < dp.length && list.size() > 0) {
            if (p != list.get(0)[0]) {
                dp[p] = Math.max(dp[p], dp[p-1]);
                p++;
                continue;
            }

            dp[p] = Math.max(dp[p], Math.max(list.get(0)[2] + dp[list.get(0)[1]], dp[p-1]));
            System.out.println("dp["+p+"]="+dp[p]);
            list.remove(0);
        }

        return dp[dp.length-1];
        
    }
}