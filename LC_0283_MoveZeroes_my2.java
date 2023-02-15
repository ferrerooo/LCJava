public class LC_0283_MoveZeroes_my2 {
    public void moveZeroes(int[] nums) {
        
        int p1 = 0;
        int p2 = 0;

        while (p2 < nums.length) {

            if (nums[p2] == 0) {
                p2++;
                continue;
            }

            swap(nums, p1, p2);
            p1++;
            p2++;
        }

    }

    private void swap(int[] nums, int p1, int p2) {
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }
}