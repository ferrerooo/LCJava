import java.util.*;

public class LC_0290_WordPattern {
    public boolean wordPattern(String pattern, String s) {
        
                
        String[] arr = s.split(" ");
        
        if (pattern.length() != arr.length)
            return false;
        
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        
        char[] charArr = pattern.toCharArray();
        
        for (int i = 0; i<charArr.length; i++) {
            
            Character c = charArr[i];
            
            if (!map1.containsKey(c)) {
                map1.put(c, arr[i]);
            } else {
                if (!map1.get(c).equals(arr[i]))
                    return false;
            }
            
            if (!map2.containsKey(arr[i])) {
                map2.put(arr[i], c);
            } else {
                if (!map2.get(arr[i]).equals(c))
                    return false;
            }
        }
        
        return true;
        
    }
}