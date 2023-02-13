import java.util.*;

public class LC_0084_LargestRectangleinHistogram_my1 {
    
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();

        stack.push(-1);
        stack.push(0);

        int res = 0;

        for (int i=1; i<heights.length; i++) {

            if (heights[i] >= heights[stack.peek()]) {
                stack.push(i);
                continue;
            }

            while (stack.size() > 1 && heights[i] < heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int w = i - stack.peek() -1;
                res = Math.max(res, h*w);
            }

            stack.push(i);
        }

        int index = heights.length;

        while (stack.size() > 1) {

            int h = heights[stack.pop()];
            int w = index - stack.peek() -1;
            res = Math.max(res, h*w);
        }

        return res;
        
    }
}
