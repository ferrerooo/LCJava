import java.util.*;

public class LC_0395_LongestSubstringwithAtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        
        int len = s.length();
        int maxLen = 0;

        for(int i=1; i<=26; i++) {

            int p1 = 0;
            int p2 = 0;
            Map<Character, Integer> map = new HashMap<>();

            while (p2 < len) {
                char cur = s.charAt(p2);
                map.put(cur, map.getOrDefault(cur, 0) + 1);

                if (map.size() == i) {
                    boolean update = true;
                    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                        if (entry.getValue() < k) {
                            p2++;
                            update = false;
                            break;
                        }
                    }
                    if (update) {
                        maxLen = Math.max(maxLen, p2-p1+1);
                        System.out.println("i is "+i+"; p2 is "+p2+"; p1 is"+p1);
                        p2++;
                    }
                } else if (map.size() < i) {
                    p2++;
                } else {
                    
                    while (map.size() > i) {
                        char remove = s.charAt(p1);
                        map.put(remove, map.get(remove) - 1);
                        p1++;
                        if (map.get(remove) == 0)
                            map.remove(remove);
                    }
                    p2++;
                }
            }

        }

        return maxLen;

        /*int len = s.length();
        int maxLen = 0;

        for (int i=0; i<len; i++) {
            Map<Character, Integer> map = new HashMap<>();
            Set<Character> set = new HashSet<>();

            for (int j=i; j<len; j++) {

                char cur = s.charAt(j);
                map.put(cur, map.getOrDefault(cur, 0) + 1);
                if (map.get(cur) >= k) {
                    set.add(cur);
                }

                if (set.size() == map.size()) {
                    maxLen = Math.max(maxLen, j-i+1);
                }
            }
        }
        return maxLen;*/

    }
}