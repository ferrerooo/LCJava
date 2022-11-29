import java.util.*;

public class LC_0291_WordPatternII {
    public boolean wordPatternMatch(String pattern, String s) {
        
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        
        return this.dfs(pattern, 0, s, 0, map1, map2);
    }
    
    private boolean dfs(String pattern, int pindex, String s, int sindex, Map<Character,String> map1, Map<String,Character> map2) {
        
        // here assume the "mapping to string" cannot be ""
        if (sindex >= s.length())
            return false;
            
        Character c = pattern.charAt(pindex);
        
        if (pindex == pattern.length() - 1) {
            
            String substr = s.substring(sindex);
            
            if (map1.containsKey(c) && !map1.get(c).equals(substr)) {
                return false;
            }
            
            if (map2.containsKey(substr) && !map2.get(substr).equals(c)) {
                return false;
            }
            
            return true;
        }
        
        for (int i = sindex+1; i <= s.length(); i++) {
            
            String substr = s.substring(sindex, i);
            
            if (map1.containsKey(c) && !map1.get(c).equals(substr)) {
                continue;
            } 
            
            if (map2.containsKey(substr) && !map2.get(substr).equals(c)) {
                continue;
            }
            
            if (!map1.containsKey(c)) {
                map1.put(c, substr);
            }
            
            if (!map2.containsKey(substr)) {
                map2.put(substr, c);
            }
            
            boolean ret = this.dfs(pattern, pindex+1, s, i, map1, map2);
            
            if (ret == true) {
                return true;
            } else {
                map1.remove(c);
                map2.remove(substr);
            }
        }
        
        return false;
    }
}