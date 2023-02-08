public class LC_0280_WiggleSort_greedy {
    public void wiggleSort(int[] nums) {

        for (int i=0; i<nums.length-1; i++) {

            if (i%2 == 0) {
                if (nums[i] > nums[i+1]) 
                    swap(nums, i, i+1);
            } else {
                if (nums[i] < nums[i+1]) 
                    swap(nums, i, i+1);
            }
        }

        return;       
    }

    private void swap(int[] nums, int p1, int p2) {
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }
}