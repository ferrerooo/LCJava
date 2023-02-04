import java.util.*;

public class LC_0472_ConcatenatedWords {
    
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        
        Set<String> dict = new HashSet<>();
        for (String w : words)
            dict.add(w);
        
        List<String> res = new ArrayList<>();

        for (String w:words) {

            dict.remove(w);
            if (isConcatenated(w, dict)) {
                res.add(w);
            }

            dict.add(w);
        }

        return res;
    }

    private boolean isConcatenated(String word, Set<String> dict) {

        boolean[] dp = new boolean[word.length()+1];
        dp[0] = true;

        for (int i=1; i<dp.length; i++) {

            for (int j=i-1; j>=0; j--) {

                String sub = word.substring(j,i);

                if (dict.contains(sub) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[dp.length-1];
    }
}