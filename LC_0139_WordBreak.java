import java.util.*;;

public class LC_0139_WordBreak {
    
    public boolean wordBreak(String s, List<String> wordDict) {
        
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        
        for (int i=1; i<dp.length; i++) {
            
            for (int j=i; j>0; j--) {
                
                if (dp[j-1] && wordDict.contains(s.substring(j-1, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[dp.length-1];
    }

}
