public class LC_0540_SingleElementinaSortedArray {
    public int singleNonDuplicate(int[] nums) {

        int p1 = 0;
        int p2 = nums.length-1;

        while (p1 <= p2) {

            int m = p1 + (p2-p1)/2;

            if (p1 == p2) {
                return nums[p1];
            } else if (nums[m] != nums[m+1] && nums[m]!=nums[m-1]) {
                return nums[m];
            } else if (nums[m] == nums[m-1] && (m-p1+1)%2==0) {
                p1 = m+1;
            } else if (nums[m] == nums[m-1] && (m-p1+1)%2==1) {
                p2 = m;
            } else if (nums[m] == nums[m+1] && (p2-m+1)%2==0) {
                p2 = m-1;
            } else if (nums[m] == nums[m+1] && (p2-m+1)%2==1) {
                p1 = m;
            } else {
                // not reachable
            }
        }
        
        return -1;
    }
}