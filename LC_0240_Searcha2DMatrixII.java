public class LC_0240_Searcha2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length;
        int n = matrix[0].length;

        int x = m-1; 
        int y = 0;

        while (matrix[x][y] != target) {
            int cur = matrix[x][y];

            if (cur > target) {
                x = x-1;
            } else {
                y = y+1;
            }

            if (x<0 || y>=n)
                return false;
        }

        return true;
    }
}