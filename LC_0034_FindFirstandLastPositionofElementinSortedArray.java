class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int a = this.getLeftBound(nums, target);

        if (a == -1)
            return new int[]{-1,-1};

        int b = this.getRightBound(nums, target);

        return new int[]{a, b};

    }
    
    private int getLeftBound(int[] nums, int target) {

        int p1 = 0; 
        int p2 = nums.length-1;
        int res = -1;

        while (p1 <= p2) {
            int mid = p1 + (p2-p1)/2;
            if (nums[mid] > target) {
                p2 = mid-1;
            } else if (nums[mid] < target) {
                p1 = mid+1;
            } else {
                if (mid == p1 || nums[mid-1] != target) {
                    res = mid;
                    break;
                } else {
                    p2 = mid-1;
                }
            }
        }

        return res;
    }

    private int getRightBound(int[] nums, int target) {
        
        int p1 = 0; 
        int p2 = nums.length-1;
        int res = -1;

        while (p1 <= p2) {
            int mid = p1 + (p2-p1)/2;
            if (nums[mid] > target) {
                p2 = mid-1;
            } else if (nums[mid] < target) {
                p1 = mid+1;
            } else {
                if (mid==p2 || nums[mid+1] != target) {
                    res = mid;
                    break;
                } else {
                    p1 = mid+1;
                }
            }
        }

        return res;
    }
}
