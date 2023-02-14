import java.util.*;

public class LC_0907_SumofSubarrayMinimums_MonotonicQ_timeout {
    public int sumSubarrayMins(int[] arr) {
        
        int mod = 1000000007;

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        for (int i=0 ;i<arr.length; i++) {
            while (stack1.size() > 0 && arr[stack1.peek()] > arr[i]) {
                stack1.pop();
            }
            if (stack1.size() == 0){
                left[i] = -1;
            } else {
                left[i] = stack1.peek();
            }
            stack1.push(i);
            //----

            int j = arr.length-1-i;
            while (stack2.size()>0 && arr[stack2.peek()] >= arr[j] ) {
                stack2.pop();
            }

            if (stack2.size() == 0) {
                right[j] = arr.length;
            } else {
                right[j] = stack2.peek();
            }
            
            stack2.push(j);

        }

        int ans = 0;

        /*for (int i:left) {
            System.out.print(i+", ");
        }
        System.out.println();
        for (int i:right) {
            System.out.print(i+", ");
        }
        System.out.println();*/

        for (int i=0; i<arr.length; i++) {

            int l = i-left[i];
            int r = (right[i]-i);
            //System.out.println("l:"+l+", r:"+r+", arr[i]"+arr[i]);
            ans = (ans%mod + (l * r * arr[i])%mod)%mod;
        }

        return ans;


    }
}