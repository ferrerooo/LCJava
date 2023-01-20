public class LC_0283_MoveZeroes {
    public void moveZeroes(int[] nums) {
        
        int index0 = this.getNext0Index(nums, -1);
        if (index0 == -1)
            return;

        int indexNon0 = 0;

        while (indexNon0 < nums.length) {

            if (nums[indexNon0] == 0) {
                indexNon0++;
                continue;
            }

            if (indexNon0 < index0) {
                indexNon0++;
                continue;
            }

            this.swap(nums, index0, indexNon0);
            index0 = this.getNext0Index(nums, index0);
            indexNon0++;

        }

        return;
    }

    private void swap (int[] nums, int p1, int p2) {
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }

    private int getNext0Index(int[] nums, int start) {
        start = start + 1;
        while (start < nums.length) {
            if (nums[start] == 0)
                return start;
            else
                start++;
        }
        return -1;
    }
}