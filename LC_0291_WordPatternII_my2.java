import java.util.*;

public class LC_0291_WordPatternII_my2 {
    
    private Map<Character, String> map1 = new HashMap<>();
    private Map<String, Character> map2 = new HashMap<>();

    public boolean wordPatternMatch(String pattern, String s) {
        
        int pindex = 0;
        int sindex = 0;

        return dfs(pattern, pindex, s, sindex);

    }

    private boolean dfs(String pattern, int pindex, String s, int sindex) {

        char curC = pattern.charAt(pindex);

        if (pindex == pattern.length()-1) {

            if (sindex == s.length()) {
                return false;
            }

            String curStr = s.substring(sindex);

            if (map1.containsKey(curC) && !map1.get(curC).equals(curStr)) {
                return false;
            }

            if (map2.containsKey(curStr) && map2.get(curStr)!=curC) {
                return false;
            }

            return true;

        }

        for (int i=sindex; i<s.length(); i++) {
            
            String curStr = s.substring(sindex, i+1);

            if (!map1.containsKey(curC) && !map2.containsKey(curStr)) {
                map1.put(curC, curStr);
                map2.put(curStr, curC);
                if (dfs(pattern, pindex+1, s, i+1)) {
                    return true;
                }
                map1.remove(curC);
                map2.remove(curStr);
                continue;
            }

            if (map1.containsKey(curC) && map2.containsKey(curStr)) {
                if (map1.get(curC).equals(curStr) && map2.get(curStr) == curC) {
                    if (dfs(pattern, pindex+1, s, i+1))
                        return true;
                }
            }

            // for other cases, they are invalid, so no need to go deeper

        }

        return false;

    }
}