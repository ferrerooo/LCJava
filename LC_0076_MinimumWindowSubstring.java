import java.util.*;

public class LC_0076_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int len = s.length();
        int count = 0;
        int p1 = 0; 
        int p2 = 0;
        int minLen = Integer.MAX_VALUE;
        String result = "";

        while (p2 < len) {

            char c = s.charAt(p2);
            if (!map.containsKey(c)) {
                p2++;
                continue;
            }

            map.put(c, map.get(c) - 1);
            
            if (map.get(c) >= 0) {
                count ++;

                while (count == t.length()) {
                    
                    char c1 = s.charAt(p1);

                    if (!map.containsKey(c1)) {
                        p1++;
                        continue;
                    } 

                    if (map.containsKey(c1) ) {
                        if (map.get(s.charAt(p1)) < 0) {
                            map.put(c1, map.get(c1)+1);
                        } else {
                            map.put(c1, map.get(c1)+1);
                            count--;

                            if (minLen > p2-p1+1) {
                                minLen = p2-p1+1;
                                result = s.substring(p1, p2+1);
                            }
                        }                
                    }
                    p1++;
                }
            }
            p2++;
        }
        return result;
    }
}