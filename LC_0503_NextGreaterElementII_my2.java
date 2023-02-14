import java.util.*;

public class LC_0503_NextGreaterElementII_my2 {
    
    public int[] nextGreaterElements(int[] nums) {

        int[] ans = new int[nums.length];

        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<nums.length; i++) {

            while (stack.size() >0 && nums[i] > nums[stack.peek()]) {
                int index = stack.pop();
                ans[index] = nums[i];
            }

            stack.push(i);
        }

        for (int i=0; i<nums.length; i++) {
            while (stack.size() > 0 && nums[i] > nums[stack.peek()]) {
                int index = stack.pop();
                ans[index] = nums[i];
            }
        }
        
        while (stack.size() > 0) {
            int index = stack.pop();
            ans[index] = -1;
        }

        return ans;
    }
}