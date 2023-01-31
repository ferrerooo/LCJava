import java.util.*;

public class LC_0212_WordSearchII_my2 {
    public List<String> findWords(char[][] board, String[] words) {
        
        Trie trie = new Trie();
        for (String w:words)
            trie.insert(w);
        
        int m = board.length;
        int n = board[0].length;
        Set<String> res = new HashSet<>();

        for (int i=0; i<m;i++) {
            for(int j=0; j<n; j++) {
                //for (String word : words)
                    dfs(board, i, j, trie.root, res);
            }
        }

        List<String> list = new ArrayList<>();

        for (String s : res) {
            list.add(s);
        }

        return list;
    }

    private void dfs(char[][] board, int row, int col, Node node, Set<String> res) {

        if (node.isWord) {
            res.add(node.word);
        }

        if (!isValid(board, row, col))
            return ;

        if (board[row][col] == '.')
            return;

        int pos = board[row][col] - 'a';
        //System.out.println(board[row][col]+","+pos);
        if (node.next[pos] == null) {
            return;
        }

        char c = board[row][col];
        board[row][col] = '.';

        //if (isValid(board, row+1, col)) {
            dfs(board, row+1, col, node.next[pos], res);
        //}

        //if (isValid(board, row-1, col)) {
            dfs(board, row-1, col, node.next[pos], res);
        //}

        //if (isValid(board, row, col+1)) {
            dfs(board, row, col+1, node.next[pos], res);
        //}

        //if (isValid(board, row, col-1)) {
            dfs(board, row, col-1, node.next[pos], res);
        //}

        board[row][col] = c;
    }

    private boolean isValid(char[][] board, int row, int col){
        int m = board.length;
        int n = board[0].length;
        if (row >=0 && row < m && col >=0 && col < n)
            return true;
        else
            return false;
    }

    private class Trie {

        Node root = new Node('0', false);

        public void insert(String s) {

            Node cur = root;
            for (int i=0; i<s.length(); i++) {
                char c = s.charAt(i);
                int pos = (int)(c - 'a');
                if (cur.next[pos] == null) {
                    cur.next[pos] = new Node(c, false);
                }
                cur = cur.next[pos];
            }

            cur.word = s;
            cur.isWord = true;
        }
    }

    private class Node {
        char c;
        boolean isWord = false;
        String word = "";
        Node[] next = new Node[26];
        Node(char _c, boolean _isWord) {
            c = _c;
            isWord = _isWord;
        }
    }
}