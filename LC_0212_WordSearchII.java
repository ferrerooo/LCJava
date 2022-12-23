import java.util.*;

public class LC_0212_WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        
        Trie trie = new Trie();
        for (String word:words)
            trie.insert(word);
        
        int m = board.length;
        int n = board[0].length;

        Set<String> set = new HashSet<>();

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                this.recur(board, i, j, set, trie.root, "");
            }
        }

        return new ArrayList<String>(set);
    }

    private void recur(char[][] board, int i, int j, Set<String> set, Node cur, String prefix) {

        if (!this.inBound(board, i, j))
            return;

        if (board[i][j] == '#')
            return;

        char c = board[i][j];
        int pos = c - 'a';

        if (pos < 0 || pos > 26 || cur.next[pos] == null)
            return;
        
        cur = cur.next[pos];

        if (cur.isWord)
            set.add(prefix + String.valueOf(c));
        
        board[i][j] = '#';

        this.recur(board, i, j+1, set, cur, prefix+String.valueOf(c));
        this.recur(board, i, j-1, set, cur, prefix+String.valueOf(c));
        this.recur(board, i+1, j, set, cur, prefix+String.valueOf(c));
        this.recur(board, i-1, j, set, cur, prefix+String.valueOf(c));

        board[i][j] = c;
    }

    private boolean inBound(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;

        return i>=0 && i<m && j>=0 && j<n;
    }
}

class Trie {
    public Node root;
    public Trie() {
        this.root = new Node('0');
    }

    public void insert(String s) {
        Node cur = root;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            int pos = c - 'a';
            if (cur.next[pos] == null) {
                cur.next[pos] = new Node(c);
            }
            cur = cur.next[pos];
        }
        cur.isWord = true;
    }
}

class Node {
    public char c = '0';
    public boolean isWord = false;
    public Node[] next = new Node[26];
    public Node(char c) {
        this.c = c;
    }
}

