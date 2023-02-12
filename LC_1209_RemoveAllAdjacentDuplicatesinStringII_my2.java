import java.util.*;

public class LC_1209_RemoveAllAdjacentDuplicatesinStringII_my2 {
    
    public String removeDuplicates(String s, int k) {
        
        Stack<Node> stack = new Stack<>();

        char[] arr = s.toCharArray();

        for (char c : arr) {

            if (stack.size() == 0 || stack.peek().c != c) {
                Node n = new Node(c);
                n.count = 1;
                stack.push(n);
            } else {
                stack.peek().count++;
            }

            if (stack.peek().count == k) {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();

        while (stack.size() > 0) {
            Node n = stack.pop();
            for(int i=0; i<n.count; i++) {
                sb.append(n.c);
            }
        }

        return sb.reverse().toString();

    }

    private class Node {
        char c;
        int count;
        Node(char _c) {
            c = _c;
            count = 0;
        }
    }
}