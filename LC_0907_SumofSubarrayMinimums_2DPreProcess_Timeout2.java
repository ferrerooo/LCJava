import java.util.*;

public class LC_0907_SumofSubarrayMinimums_2DPreProcess_Timeout2 {
    public int sumSubarrayMins(int[] arr) {

        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        int M = 1000000007;

        Stack<Integer> stack = new Stack<>();

        stack.push(-1);
        stack.push(0);
        left[0] = 0;

        for (int i=1; i<arr.length; i++) {

            if (arr[i] > arr[stack.peek()]) {
                left[i] = stack.peek()+1;
                stack.push(i);
                continue;
            }

            while (stack.size()>1 && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }

            left[i] = stack.peek() + 1;
            stack.push(i);
        }

        stack = new Stack<>();
        stack.push(arr.length);
        stack.push(arr.length-1);
        right[arr.length-1] = arr.length-1;

        for (int i=arr.length-2; i>=0; i--) {

            if (arr[i] >= arr[stack.peek()]) {
                right[i] = stack.peek()-1;
                stack.push(i);
                continue;
            }

            while (stack.size()>1 && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }

            right[i] = stack.peek() - 1;
            stack.push(i);
        }

        for (int i:left)
            System.out.print(i+",");
        System.out.println();
        for (int i:right)
            System.out.print(i+",");

        int sum = 0;

        for (int i=0; i<arr.length; i++) {

            sum = sum%M +  (arr[i]%M)*((i-left[i]+1)%M)*((right[i]-i+1)%M)%M;
        }

        return sum%M;
        
    }
}