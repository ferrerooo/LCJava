import java.util.*;

public class LC_1235_MaximumProfitinJobScheduling_BinarySearch {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        List<int[]> list = new ArrayList<>();
        list.add(new int[]{0,0,0});

        for (int i=0; i<startTime.length; i++) {
            int[] arr = new int[3];
            arr[0] = endTime[i];
            arr[1] = startTime[i];
            arr[2] = profit[i];
            list.add(arr);
        }

        Collections.sort(list, (x,y)-> x[0]-y[0]);

        int[] dp = new int[startTime.length+1];
        dp[0] = 0;

        for (int i=1; i<list.size(); i++) {

            int curProfit = list.get(i)[2];
            int index = getIndex(list, list.get(i)[1]);
            //System.out.println("index:"+index);
            curProfit += dp[index];

            dp[i] = Math.max(dp[i-1], curProfit);
            //System.out.println("d["+i+"]:"+dp[i]);
        }

        return dp[dp.length-1];
    }

    private int getIndex(List<int[]> list, int start) {

        int p1 = 0; 
        int p2 = list.size()-1;

        while (p1<=p2) {
            int mid = p1 + (p2-p1)/2;

            if (list.get(mid)[0] > start) {
                p2 = mid-1;
            } else if (list.get(mid)[0] < start) {
                p1 = mid+1;
            } else {
                p1 = mid+1;
            }
        }

        return p2;
        /*int res = 0;
        while (true) {
            if (list.get(res)[0] <= start && list.get(res+1)[0]>start)
                break;
            else 
                res ++;
        }
        return res;*/
    }
}