class Solution {
    public int longestPalindrome(String s) {
        
        Map<Character, Integer> map = new HashMap<>();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int res = 0;
        boolean hasOdd = false;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                res = res + entry.getValue();
            } else {
                res = res + entry.getValue() - 1;
                hasOdd = true;
            }
        }

        if (hasOdd)
            res ++;

        return res;
    }
}
