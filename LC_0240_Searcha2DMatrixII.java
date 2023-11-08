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


/*
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int row = matrix.length;
        int col = matrix[0].length;

        int x = row-1;
        int y = 0;

        while (isOnBoard(x, y, row, col)) {

            if (matrix[x][y] == target) {
                return true;
            }

            if (matrix[x][y] > target) {
                x -= 1;
            } else {
                y += 1;
            }

        }

        return false;
    }

    private boolean isOnBoard(int x, int y, int row, int col) {
        if (x>=0 && x<row && y>=0 && y<col) {
            return true;
        } else {
            return false;
        }
    }
}
*/
