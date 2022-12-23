public class LC_0907_SumofSubarrayMinimums_2DPreProcess_Timeout {

    public int sumSubarrayMins(int[] arr) {

        int M = 1000000007;
        int n = arr.length;

        int[] matrix = new int[n];
        int res = 0;

        for (int i=0; i<n ;i++) {
            for (int j=i; j<n; j++) {
                if (i == j) {
                    matrix[j] = arr[i];
                    res = res%M + matrix[j]%M;
                    continue;
                }
                matrix[j] = Math.min(arr[j], matrix[j-1]);
                res = res%M + matrix[j]%M;
            }
        }
        
        return res%M;
    }
    
}
