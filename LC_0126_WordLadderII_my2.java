import java.util.*;

public class LC_0126_WordLadderII_my2 {

    Map<String, List<String>> parents = new HashMap<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        List<List<String>> res = new ArrayList<>();

        if (beginWord.length() != endWord.length())
            return res;
        
        Set<String> dict = new HashSet<>();
        for (String w:wordList)
            dict.add(w);

        if (!dict.contains(endWord))
            return res;
        
        Set<String> cur = new HashSet<>();
        Set<String> next = new HashSet<>();
        Set<String> visited = new HashSet<>();
        cur.add(beginWord);
        visited.add(beginWord);
        dict.remove(beginWord);
        parents.put(beginWord, new ArrayList<>());

        while (cur.size() > 0) {

            for (String word : cur) {

                List<String> nextWords = getNextWords(word, visited, dict);

                for (String nw : nextWords) {

                    parents.putIfAbsent(nw, new ArrayList<>());
                    parents.get(nw).add(word);

                    next.add(nw); 
                }

            }

            for (String nw : next) {
                if (nw.equals(endWord)) {
                    //System.out.println("--"+nw);
                    List<List<String>> paths = getPaths(parents, nw);
                    for (List<String> path:paths) {
                        Collections.reverse(path);
                        res.add(path);
                    }
                }
            }

            if (res.size() > 0) {
                break;
            }

            for (String s:next) {
                visited.add(s);
                dict.remove(s);
            }

            cur = next;
            next = new HashSet<>();
        }

        return res;
    }

    private List<List<String>> getPaths(Map<String, List<String>> parents, String nw) {

        List<List<String>> res = new ArrayList<>();
        List<String> cur = new ArrayList<>();

        dfs(parents, nw, res, cur);
        return res;
    }

    private void print(List<String> cur) {
        System.out.println();
        for (String s : cur)
            System.out.print(s+ ",");
    }

    private void dfs(Map<String, List<String>> parents, String word, List<List<String>> res, List<String> cur) {

        if (parents.get(word).size() == 0) {
            //System.out.println("word " + word + " has no parent ");
            cur.add(word);
            //Collections.reverse(cur);
            res.add(new ArrayList<>(cur));
            cur.remove(cur.size()-1);
            return;
        }

        cur.add(word);
        for (String w:parents.get(word)) {
            //System.out.println("word " + word + " has parent " + w);
            dfs(parents, w, res, cur);
        }
        cur.remove(cur.size()-1);
    }

    private List<String> getNextWords(String word, Set<String> visited, Set<String> dict) {

        List<String> res = new ArrayList<>();

        for (int i=0; i<word.length(); i++) {
            
            char[] arr = word.toCharArray();
            char c = word.charAt(i);

            for (char c1 = 'a'; c1<='z'; c1++) {

                if (c1!=c) {
                    arr[i] = c1;
                    String newstr = new String(arr);
                    if (!visited.contains(newstr) && dict.contains(newstr)) {
                        res.add(newstr);
                    }
                }
            }
        }

        return res;
    }
}