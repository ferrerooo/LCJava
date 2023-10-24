class Solution {
    public int missingElement(int[] nums, int k) {

        if (nums.length == 1) {
            return nums[0] + k;
        }

        int p1 = 0;
        int p2 = nums.length-1;

        while (p2 != p1+1) {

            int m = p1 + (p2-p1)/2;
            int gap = (nums[m]-nums[p1]+1) - (m-p1+1);

            System.out.println("p1:"+p1+", p2:"+p2+", m:"+m+", gap:"+gap);

            if ( gap >= k  ) {
                p2= m;
            } else {
                p1 = m;
                k = k - gap;
            }
        }
        System.out.println("p1:"+p1+", p2:"+p2);
        int res = nums[p1] + k;
        //return res;
        if (res < nums[p2])
            return res;
        else
            return res + 1;
    }
}
