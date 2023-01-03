import java.util.*;

public class LC_0503_NextGreaterElement_II_MyIdea {
    
    public int[] nextGreaterElements(int[] nums) {

    Stack<int[]> stack = new Stack<>();
    Map<Integer, Integer> map = new HashMap<>();
    int[] res = new int[nums.length];
    for (int i=0; i<nums.length; i++)
        res[i] = -1;

    for (int i=0; i<nums.length; i++) {

        if (stack.size() == 0 || stack.peek()[0] >= nums[i]) {
            stack.push(new int[]{nums[i], i});
            continue;
        }

        while (stack.size() > 0 && stack.peek()[0] < nums[i]) {
            // map.put(stack.pop(), nums[i]);
            int[] pair = stack.pop();
            res[pair[1]] = nums[i];
        }

        stack.push(new int[]{nums[i], i});
    }

    for (int i=0; i<nums.length; i++) {

        if (stack.size() == 0 || stack.peek()[0] >= nums[i]) {
            stack.push(new int[]{nums[i], i});
            continue;
        }

        while (stack.size() > 0 && stack.peek()[0] < nums[i]) {
            int[] pair = stack.pop();
            res[pair[1]] = nums[i];
        }  

        stack.push(new int[]{nums[i], i});     
    }

    return res;
}
}