class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++) {

            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            } 

            if (c == ')') {
                if (stack.size() == 0 || stack.peek() != '(') {
                    return false;
                } else {
                    stack.pop();
                }
            }

            if (c == ']') {
                if (stack.size() == 0 || stack.peek() != '[') {
                    return false;
                } else {
                    stack.pop();
                }
            }

            if (c == '}') {
                if (stack.size() == 0 || stack.peek() != '{') {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        if (stack.size() >0)
            return false;

        return true;

    }
}
