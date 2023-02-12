public class LC_0378_KthSmallestElementinaSortedMatrix {
    
    public int kthSmallest(int[][] matrix, int k) {
        
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];

        while (low < high) {

            int mid = low + (high-low)/2;

            int count = this.getLowerOrEqual(matrix, mid);

            if (count < k) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        
        return high;
    }

    private int getLowerOrEqual(int[][] matrix, int target) {

        int count = 0;
        int n = matrix.length;
        int x = n-1; 
        int y = 0;

        while (x>=0 && y<n) {

            int cur = matrix[x][y];
            if (cur <= target) {
                count = count + x + 1;
                y++;
            } else {
                x = x-1;
            }
        }
        return count;
    }
}