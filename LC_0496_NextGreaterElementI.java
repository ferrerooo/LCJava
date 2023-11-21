import java.util.*;

public class LC_0496_NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num:nums2) {

            while (stack.size() > 0 && num > stack.peek()) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        
        int[] res = new int[nums1.length];

        for (int i=0; i<res.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        } 

        return res;

    }
}

/*
class Solution:
    def nextGreaterElement(self, nums1: List[int], nums2: List[int]) -> List[int]:
        d = {}
        stack = []
        for n in nums2:
            while len(stack) > 0 and n > stack[-1]:
                d[stack.pop()] = n
            stack.append(n)
        
        answer = []
        for n in nums1:
            if n in d:
                answer.append(d[n])
            else:
                answer.append(-1)
            
        return answer

*/
