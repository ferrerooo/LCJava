import java.util.*;

public class LC_0395_LongestSubstringwithAtLeastKRepeatingCharacters_my1BF {


    public int longestSubstring(String s, int k) {

        int res = 0;
        for (int i=0; i<s.length();i++) {

            Map<Character, Integer> map = new HashMap<>();
            for (int j=i; j<s.length(); j++) {

                char c = s.charAt(j);
                map.put(c, map.getOrDefault(c, 0)+1);
                if (j-i+1 < k)
                    continue;
                    
                if (isQualify(map, k)) {
                    res = Math.max(res, j-i+1);
                }
            }
        }

        return res;       
    }

    private boolean isQualify(Map<Character, Integer> map, int k) {

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() < k)
                return false;
        }

        return true;
    }
}