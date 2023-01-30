import java.util.*;

public class LC_0126_WordLadderII {
    
    Map<String, List<String>> neighborCache = new HashMap<>();
    Map<String, List<String>> parents = new HashMap<>();
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> res = new ArrayList<>();

        Set<String> set = new HashSet<>();
        for (String s : wordList)
            set.add(s);

        if (!set.contains(endWord))
            return res;
        
        if (beginWord.length() != endWord.length())
            return res;

        Set<String> cur = new HashSet<>();
        Set<String> next = new HashSet<>();
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        set.remove(beginWord);
        cur.add(beginWord);
        parents.put(beginWord, new ArrayList<>());

        while (cur.size() > 0) {

            //System.out.println(cur.size());
            //while (cur.size() >0) {
            for (String word : cur) {
                
                List<String> nextStrs = getNextStrs(word, set, visited);
                //System.out.println(nextStrs.size());

                for (String ns:nextStrs) {
                        
                        next.add(ns);

                        if (endWord.equals(ns)) {
                            List<LinkedList<String>> paths = (getPaths(ns,word,parents,beginWord));
                            for (LinkedList<String> l : paths) {
                                res.add(l);
                            }
                        }

                        if (!parents.containsKey(ns)) {
                            parents.put(ns, new ArrayList<>());
                        }
                        parents.get(ns).add(word);
                    //}
                }

            }

            if (res.size() > 0)
                break;

            for (String nextword : next) {
                visited.add(nextword);
                set.remove(nextword);
            }

            cur = next;
            next = new HashSet<>();

        }

        return res;        
    }

    private List<LinkedList<String>> getPaths(String word, String parent, Map<String, List<String>> parents, String beginWord) {

        List<LinkedList<String>> lists = new ArrayList<>();
        LinkedList<String> list = new LinkedList<>();

        dfs(parent, parents, beginWord, list, lists);
        for (LinkedList<String> ll : lists) {
            ll.offer(word);
        }
        return lists;
    }

    private void dfs(String parent, Map<String, List<String>> parents, String beginWord, LinkedList<String> list, List<LinkedList<String>> lists) {
        if (parent.equals(beginWord)) {
            list.offerFirst(parent);
            lists.add(new LinkedList<>(list));
            list.pollFirst();
            return;
        }

        list.offerFirst(parent);
        for (String p : parents.get(parent)) {
            dfs(p, parents, beginWord, list, lists);
        }
        list.pollFirst();
    }

    private List<String> getNextStrs(String s, Set<String> set, Set<String> visited) {

        if (neighborCache.containsKey(s))
            return neighborCache.get(s);

        List<String> res = new ArrayList<>();

        for (int i=0; i<s.length(); i++) {
            char[] carr = s.toCharArray();  
            char c = s.charAt(i);

            for (char j = 'a'; j<='z'; j++) {
                
                if ( c!= j) {
                    carr[i] = j;
                    String newStr = new String(carr);
                    if (set.contains(newStr) && !visited.contains(newStr))
                        res.add(newStr);
                }
            }
        }

        neighborCache.put(s, res);

        return res;
    }
}