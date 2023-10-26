class Solution {
    public String minRemoveToMakeValid(String s) {

        Stack<Pair> stack = new Stack<>();

        for (int i=0; i<s.length(); i++) {

            char c = s.charAt(i);
            if (c=='(') {
                stack.push(new Pair(c, i));
            } else if (c ==')') {
                if (stack.size() > 0 && stack.peek().c == '(')
                    stack.pop();
                else 
                    stack.push(new Pair(c, i));
            } 
        }

        Set<Integer> removed = new HashSet<>();
        while (stack.size() > 0) {
            removed.add(stack.pop().index);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i< s.length(); i++) {

            if (!removed.contains(i)) {
                sb.append(s.charAt(i));
            }

        }

        return sb.toString();
        
    }

    class Pair {
        public Pair(char c, int i) {
            this.c = c;
            this.index = i;
        }
        public char c;
        public int index;
    }
}
