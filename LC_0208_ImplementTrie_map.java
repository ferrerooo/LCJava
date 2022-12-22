import java.util.*;

public class LC_0208_ImplementTrie_map {
    private Node root;

    public LC_0208_ImplementTrie_map() {
        this.root = new Node();
    }
    
    public void insert(String word) {
        
        Node cur = root;
        for (int i = 0; i<word.length(); i++) {

            char c = word.charAt(i);

            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new Node());
                cur.children.get(c).c = c;
            }

            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        
        Node cur = root;

        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.children.containsKey(c)) {
                return false;
            } else {
                cur = cur.children.get(c);
            }
        }

        return cur.isWord;

    }
    
    public boolean startsWith(String prefix) {
        
        Node cur = root;

        for (int i=0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!cur.children.containsKey(c)) {
                return false;
            } else {
                cur = cur.children.get(c);
            }
        }

        return true;

    }

}

class Node {
    public char c = '0';
    public boolean isWord = false;
    public Map<Character, Node> children = new HashMap<>();
}