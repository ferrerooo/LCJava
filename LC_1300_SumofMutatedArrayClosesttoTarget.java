class Solution {
    public int findBestValue(int[] arr, int target) {
        
        int p1 = 0;
        int p2 = arr[0];

        for (int i:arr) {
            //p1 = Math.min(p1, i);
            p2 = Math.max(p2, i);
        }
        
        int gap = Integer.MAX_VALUE;
        int index = -1;

        while (p1 <= p2) {

            int m = p1+(p2-p1)/2;

            int sum = this.getSum(arr, m);

            if (sum == target)
                return m;

            if (Math.abs(target - sum) < gap) {
                gap = Math.abs(target - sum);
                index = m;
            } else if (Math.abs(target - sum) == gap) {
                index = Math.min(index, m);
            }

            if (sum > target) 
                p2 = m-1;
            else
                p1 = m+1;
        }

        return index;
    }

    private int getSum(int[] arr, int m) {
        int sum = 0;
        for (int i:arr) {
            if (i<m) {
                sum = sum + i;
            } else {
                sum = sum + m;
            }
        }
        return sum;
    }
}
