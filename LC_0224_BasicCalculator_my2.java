import java.util.*;

public class LC_0224_BasicCalculator_my2 {

    public int calculate(String s) {

        List<String> arr = this.parse(s);       
        Stack<String> stack = new Stack<>();

        for (int i=0; i<arr.size(); i++) {
            if (!arr.get(i).equals(")")) {
                stack.push(arr.get(i));
            } else {
                // LinkedList<String> deque = new LinkedList<>();
                int sum = 0;
                while (!stack.peek().equals("(")) {
                    String b= stack.pop();
                    if (stack.peek().equals("("))
                        sum = sum + Integer.parseInt(b);
                    else if (stack.peek().equals("+")) {
                        sum = sum + Integer.parseInt(b);
                        stack.pop();
                    } else {
                        sum = sum - Integer.parseInt(b);
                        stack.pop();
                    }
                    //deque.offerFirst(stack.pop());
                }
                stack.pop();
                //String value = this.calculate(deque);
                stack.push(String.valueOf(sum));
            }
        }

        LinkedList<String> dq = new LinkedList<>();
        while (stack.size()>0)
            dq.offerFirst(stack.pop());
        
        String res = this.calculate(dq);

        return Integer.parseInt(res);
    }

    private String calculate(LinkedList<String> dq) {
        if (dq.peekFirst().equals("-")) {
            dq.offerFirst("0");
        }

        while (dq.size() != 1) {
            int a = Integer.parseInt(dq.poll());
            String op = dq.poll();
            int b = Integer.parseInt(dq.poll());
            if (op.equals("+")) {
                dq.offerFirst(String.valueOf(a+b));
            } else {
                dq.offerFirst(String.valueOf(a-b));
            }
        }

        return dq.peek();
    }

    private List<String> parse(String s) {

        List<String> list = new LinkedList<>();
        int p1 = 0;

        while (p1 < s.length()) {

            if (s.charAt(p1) == '+') {
                list.add("+");
                p1++;
                continue;
            }

            if (s.charAt(p1) == '-') {
                list.add("-");
                p1++;
                continue;
            }

            if (s.charAt(p1) == '(') {
                list.add("(");
                p1++;
                continue;
            }

            if (s.charAt(p1) == ')') {
                list.add(")");
                p1++;
                continue;
            }

            if (s.charAt(p1) == ' ') {
                p1++;
                continue;
            }

            // digits
            int p2 = p1+1;
            while (p2<s.length() && s.charAt(p2) >= '0' && s.charAt(p2) <= '9') {
                p2++;
            }
            String num = s.substring(p1, p2);
            list.add(num);
            p1 = p2;

        }

        return list;
    }
    
}
