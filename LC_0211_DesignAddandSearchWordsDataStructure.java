public class LC_0211_DesignAddandSearchWordsDataStructure {
    private Node root;

    public LC_0211_DesignAddandSearchWordsDataStructure() {
        this.root = new Node('0');
    }
    
    public void addWord(String word) {
        
        Node cur = root;
        for (int i=0; i<word.length(); i++) {

            int pos = word.charAt(i) - 'a';
            if (cur.children[pos] == null) {
                cur.children[pos] = new Node(word.charAt(i));
            }
            cur = cur.children[pos];
        }

        cur.isWord = true;
    }
    
    public boolean search(String word) {
        
        if (word.length() == 0)
            return true;

        return this.recur(root, word);
    }

    private boolean recur(Node node, String word) {

        if (node == null || word == null)
            return false;
        
        if (word.length() == 0) {
            return node.isWord;
        }

        char c = word.charAt(0);

        if (c != '.') {
            int pos = c - 'a';
            if (node.children[pos] == null)
                return false;
            else
                return this.recur(node.children[pos], word.substring(1));
        } else {

            for (int i=0; i<26; i++) {
                if (this.recur(node.children[i], word.substring(1))) {
                    return true;
                }
            }

            return false;
        }
    }

    private class Node {
        public boolean isWord = false;
        public char c = '0';
        public Node[] children = new Node[26];
        public Node(char _c) {
            this.c = _c;
        }
    }
}
