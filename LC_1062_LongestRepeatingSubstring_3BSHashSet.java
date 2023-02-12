import java.util.*;

public class LC_1062_LongestRepeatingSubstring_3BSHashSet {
  public int longestRepeatingSubstring(String s) {

    int p1 = 1; 
    int p2 = s.length()-1;
    int result = 0;

    while (p1 <= p2) {

      int mid = p1 + (p2-p1)/2;

      if (hasRepeatStr(s, mid)) {
        result = mid;
        p1 = mid + 1;
      } else {
        p2 = mid - 1;
      }
    }
    
    return result;
  }

  private boolean hasRepeatStr(String s, int len) {

    Set<String> set = new HashSet<>();

    for (int i=0; i+len<=s.length(); i++) {
      String sub = s.substring(i, i+len);
      if (set.contains(sub)) {
        return true;
      } else {
        set.add(sub);
      }
    }

    return false;
  }
}