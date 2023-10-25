class Solution {
    public String removeDuplicates(String s) {

        Stack<Character> stack = new Stack<>();
        stack.push('0');

        for (int i=0; i<s.length(); i++) {

            char c = s.charAt(i);

            if (stack.peek() != c) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();

        while (stack.size() > 1) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
        
    }
}
