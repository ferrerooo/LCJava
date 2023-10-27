class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i< asteroids.length; i++) {

            int cur = asteroids[i];

            if( stack.size() == 0) {
                stack.push(cur);
                continue;
            }

            if ((cur > 0 && stack.peek() > 0) || (cur < 0 && stack.peek() < 0) || (cur > 0 && stack.peek() < 0)) {
                stack.push(cur);
                continue;
            }

            if (stack.peek() > (-1)*cur) {
                continue;
            } else if (stack.peek() == (-1)*cur) {
                stack.pop();
                continue;
            } else {
                stack.pop();
                i--;
            }

        }

        int[] res = new int[stack.size()];

        for (int i=res.length-1; i>=0; i--) {
            res[i] = stack.pop();
        }

        return res;
        
    }
}
