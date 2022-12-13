import java.util.*;;

public class LC_0127_WordLadder_BFS {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        // BFS
        int result = 1;
        Set<String> visited = new HashSet<>();
        Set<String> current = new HashSet<>();
        Set<String> next = new HashSet<>();

        current.add(beginWord);

        while (current.size() > 0) {

            for (String str : current) {
                visited.add(str);
                for (String word : wordList) {
                    if (!visited.contains(word) 
                            && !current.contains(word)
                            && this.isDifferBySingle(str, word))
                        if (endWord.equals(word)) {
                            return result+1;
                        } else {
                            next.add(word);
                        }
                }
            }

            current = next;
            next = new HashSet<>();
            result++;
        }

        return 0;
    }

    private boolean isDifferBySingle(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length())
            return false;
        
        if (s1.equals(s2))
            return false;

        int len = s1.length();
        int diff = 0;
        for (int i=0; i<len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff ++;
                if (diff >1)
                    return false;
            }
        }
        return true;
    }
    
}
