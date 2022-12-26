import java.util.*;

public class LC_0017_LetterCombinationsofaPhoneNumber {
    
    public List<String> letterCombinations(String digits) {
        
        if (digits == null || digits.length() == 0)
            return new ArrayList<>();

        Map<Integer, List<Character>> map = new HashMap<>();
        this.init(map);
        List<String> res = new ArrayList<>();
        
        this.recur(digits, 0, map, res, "");
        return res;
    }
    
    private void recur(String digits, int index, Map<Integer, List<Character>> map, List<String> res, String cur) {
        
        if (index == digits.length()) {
            res.add(cur);
            return;
        }

        List<Character> list = map.get((int)(digits.charAt(index) - '0'));

        for (char c : list) {

            this.recur(digits, index+1, map, res, cur+c);

        }
    }
    
    private void init(Map<Integer, List<Character>> map) {
        map.put(2, List.of('a', 'b', 'c'));
        map.put(3, List.of('d', 'e', 'f'));
        map.put(4, List.of('g', 'h', 'i'));
        map.put(5, List.of('j', 'k', 'l'));
        map.put(6, List.of('m', 'n', 'o'));
        map.put(7, List.of('p', 'q', 'r', 's'));
        map.put(8, List.of('t', 'u', 'v'));
        map.put(9, List.of('w', 'x', 'y', 'z'));
    }
}