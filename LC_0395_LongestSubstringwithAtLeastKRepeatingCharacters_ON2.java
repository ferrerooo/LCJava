import java.util.*;

public class LC_0395_LongestSubstringwithAtLeastKRepeatingCharacters_ON2 {
    public int longestSubstring(String s, int k) {
        
        int ans = 0;

        for (int i=1; i<=26; i++) {

            Map<Character, Integer> map = new HashMap<>();

            int p1 = 0;
            int p2 = 0;

            while (p2 <s.length()) {

                char c = s.charAt(p2);

                map.put(c, map.getOrDefault(c, 0)+1);

                if (map.size() == i) {

                    boolean updateAns = true;
                    for (char key:map.keySet()) {
                        if (map.get(key)<k) {
                            updateAns = false;
                            break;
                        }
                    }

                    if (updateAns) {
                        ans = Math.max(ans, p2-p1+1);
                    }

                } else if (map.size() > i) {

                    while (map.size() > i) {
                        char c1 = s.charAt(p1);
                        map.put(c1, map.get(c1)-1);
                        if (map.get(c1) == 0) {
                            map.remove(c1);
                        }
                        p1++;
                    }

                } else { // map.size() < i

                    // pass

                }

                p2++;

            }
        }

        return ans;
    }
}