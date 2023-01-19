import java.util.*;

public class LC_0528_RandomPickwithWeight {
    private  int[][] arr;
    public LC_0528_RandomPickwithWeight(int[] w) {

        arr = new int[w.length][2];

        for (int i=0; i<w.length; i++) {

            if (i == 0) {
                arr[i][0] = 1;
            } else {
                arr[i][0] = arr[i-1][1]+1;
            }

            arr[i][1] = arr[i][0] + w[i] - 1;
        }
        
    }
    
    public int pickIndex() {
        
        int max = arr[arr.length-1][1];
        Random r = new Random();
        int n = r.nextInt(max) + 1;

        int p1 = 0;
        int p2 = arr.length-1;

        while (p1<=p2) {
            int m = p1+(p2-p1)/2;
            if (arr[m][0]<= n && arr[m][1]>=n)
                return m;
            else if (arr[m][0]>n) {
                p2 = m-1;
            } else {
                p1 = m+1;
            }
        }

        return -1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */