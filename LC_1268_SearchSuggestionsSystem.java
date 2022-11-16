import java.util.*;

public class LC_1268_SearchSuggestionsSystem {

        public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            
            List<List<String>> result = new LinkedList<>();
            
            TrieNode root = this.generateTree(products);
            TrieNode curNode = root;
            
            for (int i = 0; i < searchWord.length(); i++) {
                
                TrieNode child = this.getChild(curNode, searchWord.charAt(i));
                List<String> l = this.getProducts(child, searchWord.substring(0, i));
                result.add(l);
                curNode = child;
            }
            
            return result;
        }
        
        private TrieNode getChild(TrieNode node, char c) {
            if (node == null)
                return null;
            return node.children[c-'a'];
        }
        
        private TrieNode generateTree(String[] products) {
            TrieNode root = new TrieNode(' ', false);
            for (String s : products) {
                char[] arr = s.toCharArray();
                TrieNode cur = root;
                for (int i=0; i<arr.length; i++) {
                    if (cur.children[arr[i]-'a'] == null) {
                        cur.children[arr[i]-'a'] = new TrieNode(arr[i], false);
                    }
                    cur = cur.children[arr[i]-'a'];
                    if (i == arr.length-1){
                        cur.isWord = true;
                    }
                }
            }
            
            return root;
        }
        
        private List<String> getProducts(TrieNode node, String prefix) {
            
            List<String> result = new LinkedList<>();
            
            if (node == null)
                return result;
            
            int size = 3;
            
            this.dfs(node,prefix,result,size);
            
            return result;
        }
        
        private void dfs(TrieNode node, String prefix, List<String> list, int n) {
            
            if (list.size() == n)
                return;
            
            if (node == null)
                return;
            
            if (node.isWord) {
                list.add(prefix+node.c);
                if (list.size() == n)
                    return;
            }
            
            for (int i=0;i<26;i++) {
                this.dfs(node.children[i], prefix+node.c, list, n);
                if (list.size() == n)
                    return;
            }
        }
        
        
        class TrieNode {
            public char c;
            TrieNode[] children = new TrieNode[26];
            boolean isWord;
            public TrieNode(char c, boolean isWord) {
                this.c = c;
                this.isWord = isWord;
            }
        }
    }