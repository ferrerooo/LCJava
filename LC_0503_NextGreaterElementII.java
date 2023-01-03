import java.util.*;

public class LC_0503_NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        int[] res = new int[nums.length];
        for (int i=0; i<nums.length; i++)
            res[i] = -1;

        stack.push(0);

        for (int i=1; i<nums.length; i++) {

            if (nums[i] <= nums[stack.peek()]) {
                stack.push(i);
                continue;
            }

            while (stack.size() > 0 && nums[i] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i];
            }

            stack.push(i);
        }

        for (int i=0; i<nums.length; i++) {

            while (stack.size() > 0 && nums[i] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i];
            }
        }

        return res;
    }
}