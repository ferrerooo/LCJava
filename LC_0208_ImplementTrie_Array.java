public class LC_0208_ImplementTrie_Array {

    private Node root;

    public LC_0208_ImplementTrie_Array() {
        root = new Node();
    }
    
    public void insert(String word) {
        
        Node cur = root;

        for (int i=0; i<word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (cur.next[pos] == null) {
                cur.next[pos] = new Node();
            }
            cur = cur.next[pos];
        }

        cur.isWord = true;

    }
    
    public boolean search(String word) {

        Node cur = root;

        for (int i=0; i<word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (cur.next[pos] != null) {
                cur = cur.next[pos];
            } else {
                return false;
            }
        }
        
        return cur.isWord;
    }
    
    public boolean startsWith(String prefix) {

        Node cur = root;

        for (int i=0; i<prefix.length(); i++) {
            int pos = prefix.charAt(i) - 'a';
            if (cur.next[pos] != null) {
                cur = cur.next[pos];
            } else {
                return false;
            }
        }
        
        return true;
    }

    private class Node {
        public boolean isWord;
        public Node[] next;

        public Node () {
            this.isWord = false;
            this.next = new Node[26];
        }
    }
    
}
