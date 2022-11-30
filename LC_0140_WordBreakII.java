import java.util.*;

public class LC_0140_WordBreakII {

    public List<String> wordBreak(String s, List<String> wordDict) {
        
        Set<String> wordSet = new HashSet<>(wordDict);
        
        return this.dfs(s, 0, wordSet);
    }
    
    private List<String> dfs(String s, int index, Set<String> wordSet) {
        
        List<String> list = new LinkedList<>();
        
        for (int i = index+1; i <= s.length(); i++) {
            
            String str = s.substring(index, i);
            
            if (wordSet.contains(str)) {
                
                if (i == s.length()) {
                    list.add(str);
                } else {
                    List<String> subList = this.dfs(s, i, wordSet);
                    if (subList != null && subList.size() > 0) {
                        for (String tmpStr : subList) {
                            list.add(str + " " + tmpStr);
                        }
                    }
                }  
            }
        }
        
        return list;
    }
    
}
