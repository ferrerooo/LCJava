public class LC_0073_SetMatrixZeroes {
    
    public void setZeroes(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;

        boolean row0Has0 = false;

        for (int i=0; i<n; i++) {
            if (matrix[0][i] == 0) {
                row0Has0 = true;
                break;
            }
        }

        boolean col0Has0 = false;

        for (int i=0; i<m; i++) {
            if (matrix[i][0] == 0) {
                col0Has0 = true;
                break;
            }
        }

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {

                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i=1; i<m ;i++) {
            if (matrix[i][0] == 0) {
                for (int j=1; j<n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i=1; i<n; i++) {
            if (matrix[0][i] == 0) {
                for (int j=1; j<m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        if (row0Has0) {
            for (int i=0; i<n; i++)
                matrix[0][i] = 0;
        }

        if (col0Has0) {
            for (int i=0; i<m; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}