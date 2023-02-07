import java.util.*;

public class LC_0054_SpiralMatrix_my2 {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;

        int small = Math.min(m, n);

        int loop = small / 2;

        List<Integer> res = new ArrayList<>();

        for (int i=0; i<loop; i++) {

            for (int j=i; j<n-i-1; j++) {
                res.add(matrix[i][j]);
            }

            for (int j=i; j<m-i-1; j++) {
                res.add(matrix[j][n-i-1]);
            }

            for (int j=n-1-i; j>=i+1; j--) {
                res.add(matrix[m-1-i][j]);
            }

            for (int j=m-1-i; j>=i+1; j--) {
                res.add(matrix[j][i]);
            }

        }

        if (small % 2 == 0) {
            return res;
        }

        if (m == n) {
            res.add(matrix[loop][loop]);
            return res;
        }

        if (m>n) {
            for (int i=loop; i<m-loop; i++) {
                res.add(matrix[i][loop]);
            }
            return res;
        }

        for (int i = loop; i<n-loop; i++) {
            res.add(matrix[loop][i]);
        }
        return res;

    }
}