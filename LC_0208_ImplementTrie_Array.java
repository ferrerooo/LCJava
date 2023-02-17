public class LC_0208_ImplementTrie_Array {

    private Node root;

    public LC_0208_ImplementTrie_Array() {
        root = new Node('0');
    }
    
    public void insert(String word) {
        
        Node node = root;

        for (int i=0; i<word.length(); i++) {
            char cur = word.charAt(i);
            int index = (int)(cur - 'a');
            if (node.children[index] == null) {
                node.children[index] = new Node(cur);
            }

            node = node.children[index];
        }

        node.isWord = true;
    }
    
    public boolean search(String word) {
        
        Node node = root;

        for (int i=0; i<word.length(); i++) {
            char cur = word.charAt(i);
            int index = (int)(cur-'a');

            if (node.children[index] != null) {
                node = node.children[index];
            } else {
                return false;
            }
        }

        return node.isWord;

    }
    
    public boolean startsWith(String prefix) {
        
        Node node = root;

        for (int i=0; i<prefix.length(); i++) {
            char cur = prefix.charAt(i);
            int index = (int)(prefix.charAt(i)-'a');

            if (node.children[index] != null) {
                node = node.children[index];
            } else {
                return false;
            }
        }

        return true;

    }

    private class Node {
        boolean isWord;
        char c;
        Node[] children;
        public Node(char _c) {
            c = _c;
            isWord = false;
            children = new Node[26];
        }
    }
}