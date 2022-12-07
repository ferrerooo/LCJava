import java.util.*;

public class LC_0299_BullsandCows {

    public String getHint(String secret, String guess) {
        
        int a = 0;
        int b = 0;

        int len = secret.length();

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i< len; i++) {
            
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);

            if (c1 == c2) {
                a++;
                continue;
            }

            if (map1.containsKey(c1)) {
                map1.put(c1, map1.get(c1)+1);
            } else {
                map1.put(c1, 1);
            }

            if (map2.containsKey(c2)) {
                map2.put(c2, map2.get(c2)+1);
            } else {
                map2.put(c2, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            Character key = entry.getKey();
            Integer val = entry.getValue();
            if (map2.containsKey(key)) {
                b = b + Math.min(val, map2.get(key));
            }
        }

        String result = String.valueOf(a) + "A" + String.valueOf(b) + "B";
        return result;
    }
    
}
