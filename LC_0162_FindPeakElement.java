class Solution {
    public int findPeakElement(int[] nums) {

        int p1 = 0; 
        int p2 = nums.length-1;

        if (nums.length == 1)
            return 0;

        while (p1 <= p2) {
            
            System.out.println("p1:"+p1+", p2:"+p2);
            int m = p1 + (p2-p1)/2;

            if (m>0 && m<nums.length-1 && nums[m]>nums[m-1] && nums[m]<nums[m+1]) {
                p1 = m+1;
            } else if (m>0 && m<nums.length-1 && nums[m]<nums[m-1] && nums[m]>nums[m+1]) {
                p2 = m-1;
            } else if (m>0 && m<nums.length-1 && nums[m]<nums[m-1] && nums[m] < nums[m+1]) {
                p1 = m+1;
            } else if (m>0 && m<nums.length-1 && nums[m]>nums[m-1] && nums[m] > nums[m+1]) {
                return m;
            } else if (m==0 && nums[m]> nums[m+1]) {
                return m;
            } else if (m==0 && nums[m]< nums[m+1]) {
                p1=m+1;
            } else if (m==nums.length-1 && nums[m]> nums[m-1]) {
                return m;
            } else if (m==nums.length-1 && nums[m]< nums[m-1]) {
                p2=m-1;
            } else {
                // 
            }

        }

        return -1;        
    }
}
