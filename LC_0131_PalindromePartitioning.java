import java.util.*;

public class LC_0131_PalindromePartitioning {
    
    public List<List<String>> partition(String s) {

        boolean[][] pal = genMatrix(s);

        //List<List<String>> res = new LinkedList<>();

        return dfs(s, pal, 0);
    }

    private LinkedList<List<String>> dfs(String s, boolean[][] pal, int index) {

        LinkedList<List<String>> res = new LinkedList<>();

        if (index == s.length()) {
            res.add(new LinkedList<>());
            return res;
        }

        for (int i=index; i<s.length(); i++) {

            if (pal[index][i]) {

                LinkedList<List<String>> sub = dfs(s, pal, i+1);
                String palStr = s.substring(index, i+1);
                for (List<String> list : sub) {
                    list.add(0, palStr);
                    res.add(list);
                }

            }
        }

        return res;
    }

    private boolean[][] genMatrix(String s) {

        int n = s.length();
        boolean[][] pal = new boolean[s.length()][s.length()];

        for (int i=0; i<n; i++) {
            pal[i][i] = true;
        }

        for (int i=1; i<n; i++) {
            if (s.charAt(i-1) == s.charAt(i)) {
                pal[i-1][i] = true;
            }
        }

        for (int i=2; i<n; i++) {
            for (int j=0; j+i<n; j++) {
                if (s.charAt(j) == s.charAt(j+i) && pal[j+1][j+i-1]) {
                    pal[j][j+i] = true;
                }
            }
        }

        return pal;
    }
}