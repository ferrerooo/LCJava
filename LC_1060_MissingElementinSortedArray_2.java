class Solution {
    public int missingElement(int[] nums, int k) {

        if (nums.length == 1) {
            return nums[0] + k;
        }
        
        int p1 = 0;
        int p2 = nums.length-1;

        while (p1+1 != p2) {

            int mid = p1 + (p2-p1)/2;

            int numCnt = mid - p1 + 1;
            int maxNumCnt = nums[mid] - nums[p1] + 1;

            int missingNumCnt = maxNumCnt - numCnt;

            if (missingNumCnt >= k) {
                p2 = mid;
            } else {
                k = k - missingNumCnt;
                p1 = mid;
            }
        }

        if (nums[p1] + 1 == nums[p2]) {
            return nums[p2] + k;
        }

        if (nums[p1] + k >= nums[p2]) {
            return nums[p1] + k + 1;
        } else {
            return nums[p1] + k;
        }
    }
}
