class Solution {
    public int removeElement(int[] nums, int val) {
        
        int p1 = 0;
        int p2 = nums.length - 1;

        while (p1 <= p2) {
            if (nums[p1] == val) {
                swap(nums, p1, p2);
                p2 --;
            } else {
                p1 ++;
            }
        }

        return p2+1;
    }

    private void swap(int[] arr, int p1, int p2) {
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
        return;
    }
}
