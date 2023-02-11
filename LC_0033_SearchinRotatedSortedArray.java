public class LC_0033_SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        
        int p1=0;
        int p2 = nums.length-1;

        while (p1 <= p2) {

            int mid = p1 + (p2-p1)/2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[p1] <= nums[mid]) {
                if (target >= nums[p1] && target < nums[mid]) {
                    p2 = mid-1;
                } else {
                    p1 = mid+1;
                }
            } else {
                if (target > nums[mid] && target <= nums[p2]) {
                    p1 = mid+1;
                } else {
                    p2 = mid-1;
                }
            }

        }

        return -1;

    }
}