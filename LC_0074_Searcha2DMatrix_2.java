class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row = matrix.length;
        int col = matrix[0].length;

        int p1 = 0;
        int p2 = row-1;

        int targetRow = -1;

        while (p1 <= p2) {

            int mid = p1 + (p2-p1)/2;

            if (matrix[mid][0] == target) {
                return true;
            }

            if (matrix[mid][0] < target) {
                if (mid == row-1) {
                    targetRow = mid;
                    break;
                }

                if (matrix[mid+1][0] <= target) {
                    p1 = mid+1;
                } else {
                    targetRow = mid;
                    break;
                }
            } else {
                p2 = mid-1;
            }
        }

        if (targetRow == -1) {
            return false;
        }

        int[] arr = matrix[targetRow];

        p1 = 0;
        p2 = col-1;

        while (p1 <= p2) {

            int mid = p1 + (p2-p1)/2;
            if (arr[mid] == target) {
                return true;
            }

            if (arr[mid] < target) {
                p1 = mid+1;
            } else {
                p2 = mid-1;
            }
        }

        return false;

    }
}
