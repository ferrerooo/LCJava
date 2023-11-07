class Solution {
    public int evalRPN(String[] tokens) {

        Stack<String> stack = new Stack<>();

        for (String token : tokens)  {

            int op1 = 0;
            int op2 = 0;

            if (!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")) {
                stack.push(token);
            } else {
                op2 = Integer.parseInt(stack.pop());
                op1 = Integer.parseInt(stack.pop());
            }

            switch (token) {

                case "+":
                    stack.push(String.valueOf(op1+op2));
                    break;
                case "-":
                    stack.push(String.valueOf(op1-op2));
                    break;
                case "*":
                    stack.push(String.valueOf(op1*op2));
                    break;
                case "/":
                    stack.push(String.valueOf(op1/op2));
                    break;
                default:
                    break;
            }

        }

        return Integer.parseInt(stack.pop());

        
    }
}
