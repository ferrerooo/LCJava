class Solution {
    public int removeElement(int[] nums, int val) {
        
        if (nums == null || nums.length == 0)
            return 0;

        int p1 = 0;
        int p2 = nums.length-1;

        while (p1 <= p2) {

            if (nums[p1] != val) {
                p1++;
            } else {

                nums[p1] = nums[p2];
                nums[p2] = val;
                p2--;
            }

        }

        return p2+1;
    }
}