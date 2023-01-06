public class LC_0075_SortColors {
    
    public void sortColors(int[] nums) {

    int pr = 0;
    int pw = 0;
    int pb = nums.length - 1;

    while (pw <= pb) {

        if (nums[pw] == 1) {
            pw++;
        } else if (nums[pw] == 0) {
            this.swap(nums, pw, pr);
            pw++;
            pr++;
        } else {
            this.swap(nums, pw, pb);
            pb--;
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
