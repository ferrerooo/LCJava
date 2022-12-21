import java.util.*;

public class LC_1062_LongestRepeatingSubstring_1Hash {

    public int longestRepeatingSubstring(String s) {
        
        int len = s.length();
        int res = 0;

        for (int l = len-1; l>0; l--) {
            Set<String> set = new HashSet<>();
            for (int i=0; i<len-l+1; i++) {

                String sub = s.substring(i, i+l);
                if (set.contains(sub))
                    return l;
                else
                    set.add(sub);
            }
        }

        return res;

    }
    
}
