public class LC_0410_SplitArrayLargestSum {

    public int splitArray(int[] nums, int k) {
        
        int p2 = 0;
        for (int i:nums)
            p2 = p2+i;
        
        int p1 = nums[0];
        for (int i:nums)
            p1 = Math.max(p1, i);
        
        //int p1 = 0;

        int res = Integer.MAX_VALUE;

        while (p1 <= p2) {

            int m = p1 + (p2-p1)/2;
            System.out.println("m:"+m);

            int groups = 0;
            int cur = 0;
            int localMax = 0;
            for (int i=0; i<nums.length; i++) {
                if (cur + nums[i] <= m) {
                    cur = cur + nums[i];
                } else {
                    groups++;
                    localMax = Math.max(localMax, cur);
                    cur = nums[i];
                }
            }

            groups++;
            localMax = Math.max(localMax, cur);

            if (groups < k) {
                //System.out.println("groups:"+groups+",k:"+k+",p1:"+p1+",p2:"+p2+",m:"+m);
                p2 = m-1;
            } else if (groups == k) {
                p2 = m-1;
                res = Math.min(res, localMax);
            } else{
                p1 = m+1;
            }  

            //System.out.println("groups:"+groups+",k:"+k+",p1:"+p1+",p2:"+p2+",m:"+m);
        }

        if (res == Integer.MAX_VALUE)
            res = p1;

        return res;
    }
}