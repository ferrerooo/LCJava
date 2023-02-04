import java.util.*;

public class LC_0329_LongestIncreasingPathinaMatrix_my1 {
    
    private int res = 0;
    public int longestIncreasingPath(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {

                int a = dfs(matrix, i, j, 1);
                //System.out.println("at point "+i+","+j+", len is "+a);
            }
        }

        return res;
    }

    Map<String, Integer> cache = new HashMap<>();

    private int dfs(int[][] matrix, int r, int c, int len) {

        if (cache.containsKey(r+","+c)) {
            res = Math.max(res, len+cache.get(r+","+c)-1);
            //System.out.println(r+","+c+" --res is "+res);
            //System.out.println(r+","+c+" == value is "+cache.get(r+","+c));
            return cache.get(r+","+c);
        } else {
            res = Math.max(res, len);
        }
        //System.out.println(r+","+c+" ---- res is "+res);

        int cur = matrix[r][c];

        int l1 = 0;
        int l2 = 0;
        int l3 = 0;
        int l4 = 0;

        if (onboard(matrix, r+1, c) && matrix[r+1][c] > cur) {
            l1 = dfs(matrix, r+1, c, len+1);
            if (r==0&&c==1) {
                System.out.println("l1 "+l1);
            }
        }

        if (onboard(matrix, r-1, c) && matrix[r-1][c] > cur) {
            l2 = dfs(matrix, r-1, c, len+1);
            if (r==0&&c==1) {
                System.out.println("l2 "+l2);
            }
        }

        if (onboard(matrix, r, c+1) && matrix[r][c+1] > cur) {
            l3 = dfs(matrix, r, c+1, len+1);
            if (r==0&&c==1) {
                System.out.println("l3 "+l3);
            }
        }

        if (onboard(matrix, r, c-1) && matrix[r][c-1] > cur) {
            l4 = dfs(matrix, r, c-1, len+1);
            if (r==0&&c==1) {
                System.out.println("l4 "+l4);
            }
        }

        int localMax = Math.max(Math.max(l1, l2), Math.max(l3, l4));

        cache.put(r+","+c, localMax+1);
        //System.out.println(r+","+c+" ==== value is "+cache.get(r+","+c)+" "+l1+":"+l2+":"+l3+":"+l4);

        return localMax + 1;
    }

    private boolean onboard(int[][] matrix, int r, int c) {
        int m = matrix.length;
        int n = matrix[0].length;

        return r>=0 && r<m && c>=0 && c<n;
    }
}