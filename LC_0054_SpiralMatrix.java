import java.util.*;

public class LC_0054_SpiralMatrix {
    
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int loop = Math.min(m, n) / 2;

        List<Integer> list = new LinkedList<>();
        int l = 0;

        while (l < loop) {

            int row = l;
            for (int i=l; i<n-1-l; i++) {
                list.add(matrix[row][i]);
            }

            int col = n-1-l;
            for (int i=row; i<m-1-l; i++) {
                list.add(matrix[i][col]);
            }

            row = m-1-l;
            for (int i=n-1-l; i>=l+1; i--) {
                list.add(matrix[row][i]);
            }

            col = l;
            for (int i=m-1-l; i>=l+1; i--) {
                list.add(matrix[i][col]);
            }

            l++;
        }

        if (Math.min(m,n) %2 ==0)
            return list;
        
        if (m < n) {
            for (int i=l; i<n-l; i++)
                list.add(matrix[l][i]);
        } else {
            for (int i=l; i<m-l; i++)
                list.add(matrix[i][l]);
        }
        
        return list;

    }
}