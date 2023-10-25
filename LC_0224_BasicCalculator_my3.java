class Solution {
    public int calculate(String s) {

        Stack<String> stack = new Stack<>();
        String numberTemp = "";

        for (char c : s.toCharArray()) {
            
            if (c < '0' || c > '9') {
                if (!numberTemp.equals("")) {
                    stack.push(numberTemp);
                    numberTemp = "";
                } 
            }

            if (c == ' ') {
                continue;
            }

            if (c == '+') {
                stack.push("+");
                continue;
            }

            if (c == '-') {
                stack.push("-");
                continue;
            }

            if (c=='(') {
                stack.push("(");
                continue;
            }

            if (c == ')') {
                int res = calculateOneUnit(stack);
                stack.push(String.valueOf(res));
                continue;
            }

            numberTemp = numberTemp + c;
        }

        if (!numberTemp.equals("")) {
            stack.push(numberTemp);
        }

        return calculateOneUnit(stack);
        
    }

    private int calculateOneUnit(Stack<String> stack) {

        LinkedList<String> llist = new LinkedList<>();

        while (stack.size() > 0 && !stack.peek().equals("(")) {
            llist.offerFirst(stack.pop());
        }

        if (stack.size() > 0&& stack.peek().equals("(")) {
            stack.pop();
        }

        if (!llist.peek().equals("+") && !llist.peek().equals("-")) {
            llist.offerFirst("+");
        }

        int result = 0;

        while (llist.size() > 0) {
            String s1 = llist.poll();
            int s2 = Integer.parseInt(llist.poll());
            if (s1.equals("+")) {
                result = result + s2;
            } else {
                result = result - s2;
            }
        }

        return result;

    }
}
