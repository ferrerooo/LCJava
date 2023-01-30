import java.util.*;

public class LC_0127_WordLadder_my2 {
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> set = new HashSet<>();
        for (String s:wordList)
            set.add(s);
        
        if (!set.contains(endWord))
            return 0;
        
        Set<String> visited = new HashSet<>();
        int step = 1;
        LinkedList<String> cur = new LinkedList<>();
        LinkedList<String> next = new LinkedList<>();
        cur.add(beginWord);
        visited.add(beginWord);

        while (cur.size() > 0) {

            while (cur.size()>0) {

                String s = cur.pollFirst();

                List<String> nextStrs = getNextStrs(s);

                for (String nextStr:nextStrs) {
                    if (set.contains(nextStr) && !visited.contains(nextStr)) {
                        next.offer(nextStr);
                        visited.add(nextStr);
                        if (nextStr.equals(endWord)) {
                            return step+1;
                        }
                    }
                }
            }

            step++;
            cur = next;
            next = new LinkedList<>();
        }

        return 0;
    }

    private List<String> getNextStrs(String s) {

        List<String> res = new ArrayList<>();

        for (int i=0; i<s.length(); i++) {

            char c = s.charAt(i);

            for (int j=0; j<26; j++) {
                char c1 = (char)('a' + j);
                if ( c!= c1) {
                    String newStr = s.substring(0, i) + String.valueOf(c1) + s.substring(i+1);
                    res.add(newStr);
                }
            }

        }
        return res;
    }
}