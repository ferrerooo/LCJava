import java.util.*;

public class LC_2062_CountVowelSubstringsofaString {

    public int countVowelSubstrings(String word) {

        Map<Character, Integer> map = this.getInitMap();
        int p1 = 0;
        int p2 = 0;
        int mid = 0;
        int result = 0;
        int count = 0;

        while (p2 < word.length()) {

            char cur = word.charAt(p2);

            if (!map.containsKey(cur)) {
                p2++;
                p1 = p2;
                mid = p2;
                count = 0;
                map = this.getInitMap();
                continue;
            }

            map.put(cur, map.get(cur)-1);
            if (map.get(cur) >= 0) {
                count++;
            }

            if (count == 5) {

                while (true) {
                    char c1 = word.charAt(mid);
                    if (map.get(c1) < 0) {
                        map.put(c1, map.get(c1)+1);
                        mid++;
                    } else {
                        break;
                    }
                }

                result += (mid+1-p1);
            }

            p2++;
        }

        return result;
    }

    private Map<Character, Integer> getInitMap() {

        Map<Character, Integer> map = new HashMap<>();
        map.put('a',1);
        map.put('e',1);
        map.put('i',1);
        map.put('o',1);
        map.put('u',1);

        return map;
    }
}
