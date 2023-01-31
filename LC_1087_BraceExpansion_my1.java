import java.util.*;

public class LC_1087_BraceExpansion_my1 {
    public String[] expand(String s) {
        
        List<List<Character>> lists = new ArrayList<>();
        parse(s, 0, lists);

        List<Character> cur = new ArrayList<>();
        int index = 0;
        List<List<Character>> res = new ArrayList<>();
        dfs(lists, index, cur, res);

        String[] result = transform(res);
        Arrays.sort(result);
        return result;
    }

    private void dfs(List<List<Character>> lists, int index, List<Character> cur, List<List<Character>> res) {

        if (index == lists.size()) {
            res.add(new ArrayList<>(cur));
            return;
        }

        List<Character> options = lists.get(index);

        for (char c : options) {
            cur.add(c);
            dfs(lists, index+1, cur, res);
            cur.remove(cur.size()-1);
        }

    }

    private String[] transform(List<List<Character>> res) {

        String[] result = new String[res.size()];
        int index = 0;
        for (List<Character> list : res) {
            StringBuilder sb = new StringBuilder();
            for (char c : list) {
                sb.append(c);
            }
            result[index] = sb.toString();
            index++;
        }

        return result;
    }

    private void parse(String s, int index, List<List<Character>> res) {

        if (index == s.length()){
            return ;
        }

        if (s.charAt(index) >='a' && s.charAt(index) <='z') {
            List<Character> list = new ArrayList<>();
            list.add(s.charAt(index));
            res.add(list);
            parse(s, index+1, res);
            return;
        }

        if (s.charAt(index) == '{') {

            int p2 = index+1;
            
            List<Character> list = new ArrayList<>();
            while (s.charAt(p2) != '}') {
                if (s.charAt(p2) >='a' && s.charAt(p2) <='z') {
                    list.add(s.charAt(p2));
                }
                p2++;
            }
            res.add(list);
            parse(s, p2+1, res);
            return;
        }

        return;

    }
}