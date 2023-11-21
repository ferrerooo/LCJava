class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<temperatures.length; i++) {

            while (stack.size() > 0 && temperatures[i] > temperatures[stack.peek()]) {
                result[stack.peek()] = i-stack.peek();
                stack.pop();
            }

            stack.push(i);
        }

        while (stack.size() > 0) {
            result[stack.pop()] = 0;
        }
        
        return result;
    }
}
