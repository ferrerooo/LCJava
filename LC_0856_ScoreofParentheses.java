import java.util.*;

public class LC_0856_ScoreofParentheses {
    public int scoreOfParentheses(String s) {
        
        LinkedList<String> list = new LinkedList<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                list.add("(");
            else
                list.add(")");
        }
        
        Stack<String> stack = new Stack<>();

        while (list.size() > 0) {

            String cur = list.pollFirst();

            if (cur.equals("(")) {
                stack.push(cur);
            } else if (cur.equals(")")) {

                if (stack.peek().equals("(")) {
                    stack.pop();
                    list.offerFirst("1");
                } else {
                    String n = stack.pop();
                    stack.pop();
                    String next = String.valueOf(Integer.valueOf(n) * 2);
                    list.offerFirst(next);
                }

            } else {
                if (stack.size() == 0 || stack.peek().equals("(")) {
                    stack.push(cur);
                } else {
                    int p = Integer.valueOf(stack.pop());
                    String next = String.valueOf(p + Integer.valueOf(cur));
                    stack.push(next);
                }
            }
        }

        return Integer.valueOf(stack.peek());
    }
}