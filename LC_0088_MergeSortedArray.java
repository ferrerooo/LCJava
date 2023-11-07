class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int cur = m + n -1;
        int p1 = m-1;
        int p2 = n-1;

        while (p1 >=0 && p2 >=0) {

            if (nums1[p1] >= nums2[p2]) {
                nums1[cur] = nums1[p1];
                p1--;
            } else {
                nums1[cur] = nums2[p2];
                p2--;
            }
            cur--;
        }
        
        if (p2 < 0)
            return ;
        
        while (p2 >=0) {
            nums1[cur] = nums2[p2];
            p2--;
            cur--;
        }

        return;
    }
}
