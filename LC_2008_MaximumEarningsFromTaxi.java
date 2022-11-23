import java.util.*;

public class LC_2008_MaximumEarningsFromTaxi {

// https://zhuanlan.zhihu.com/p/503776720
public long maxTaxiEarnings(int n, int[][] rides) {
        
    int len = rides.length;
    Arrays.sort(rides, (x,y)-> x[0]-y[0]);
    
    int result = 0;
    int[] dp = new int[len];
    dp[0] = rides[0][1] - rides[0][0] + rides[0][2];
    
    for (int i = 1; i < len; i++) {
        
        int curEarn = rides[i][1] - rides[i][0] + rides[i][2];
        int curMax = curEarn;
        
        for (int j = i-1; j>=0; j--) {
            
            if (rides[j][1] <= rides[i][0]) {
                curMax = Math.max(curEarn + dp[j], curMax);
            }
        }
        dp[i] = curMax; 
    }
    
    for (int i : dp) {
        result = Math.max(i, result);
    }
    
    return result;
}

}
