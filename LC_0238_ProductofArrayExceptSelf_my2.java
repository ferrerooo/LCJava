public class LC_0238_ProductofArrayExceptSelf_my2 {
    public int[] productExceptSelf(int[] nums) {

        int[] res = new int[nums.length];

        for (int i=0; i<res.length; i++) {
            res[i] = 1;
        }

        int cur = 1;

        for (int i=0; i<res.length; i++) {
            res[i] *= cur;
            cur *= nums[i];
        }

        cur = 1;

        for (int i=res.length-1; i>=0; i--) {
            res[i] *= cur;
            cur *= nums[i];
        }

        return res;

    }
}