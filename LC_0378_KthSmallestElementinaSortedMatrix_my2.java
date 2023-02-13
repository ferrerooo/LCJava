public class LC_0378_KthSmallestElementinaSortedMatrix_my2 {
    
    public int kthSmallest(int[][] matrix, int k) {

        int m = matrix.length;
        int n = matrix[0].length;

        int p1 = matrix[0][0];
        int p2 = matrix[m-1][n-1];

        int res = 0;

        while (p1 <= p2) {

            int mid = p1+(p2-p1)/2;

            System.out.println("Start -- p1:"+p1+";p2:"+p2+";mid:"+mid);

            // counts[0] how many less than mid; counts[1] how many equals with mid
            int[] counts = count(matrix, mid);
            
            System.out.println("-- counts[0]:"+counts[0]+";counts[1]:"+counts[1]+";k:"+k);

            if (counts[0]+counts[1]<k) {
                p1 = mid+1;
            } else if (counts[0]+counts[1]==k) {
                if (counts[1]>0) {  // based on counts[1], will know if mid is an element in the matrix
                    res = mid;
                    break;
                } else {
                    p2 = mid-1;
                }
            } else { // counts[0]+counts[1]>k
                if (counts[0] < k) {
                    res = mid;
                    break;
                } else {
                    p2 = mid-1;
                }
            }

            System.out.println("End -- p1:"+p1+";p2:"+p2+";mid:"+mid);
        }

        return res;       
    }

    private int[] count(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int lessCnt = 0;
        int equalCnt = 0;

        int x = m-1;
        int y = 0;

        while (x>=0 && y < n) {

            if (matrix[x][y] == target) {
                int z = x;
                while (z>=0 && matrix[z][y] == target) {
                    equalCnt += 1;
                    z--;
                }

                if (z>=0) {
                    lessCnt += z+1;
                }

                y++;
            } else if (matrix[x][y] < target) {
                lessCnt = lessCnt + (x+1);
                y++;
            } else {
                x--;
            }
        }
        
        return new int[]{lessCnt, equalCnt};
    }
}