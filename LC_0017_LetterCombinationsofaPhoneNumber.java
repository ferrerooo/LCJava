import java.util.*;

public class LC_0017_LetterCombinationsofaPhoneNumber {
    
    public List<String> letterCombinations(String digits) {
        
        Map<Integer, List<Character>> map = new HashMap<>();
        
        this.init(map);
        
        return this.recur(digits, 0, map);
    }
    
    private List<String> recur(String digits, int index, Map<Integer, List<Character>> map) {
        
        List<String> list = new LinkedList<>();
        
        if (index == digits.length()) 
            return list;
        
        List<String> sublist = this.recur(digits, index+1, map);
        List<Character> charList = map.get((Integer)(digits.charAt(index) - '0'));
        
        for (char c : charList) {
            if (sublist.size() == 0) {
                list.add(String.valueOf(c));
            } else {
                for (String str : sublist) {
                    list.add(String.valueOf(c) + str);
                }
            }
        }
        
        return list;
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
