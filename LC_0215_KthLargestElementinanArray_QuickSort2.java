class Solution {
    public int findKthLargest(int[] nums, int k) {

        return recur(nums, nums.length-k+1, 0, nums.length-1);
    }

    public int partition(int left, int right, int pivot_index) {
        
        int pivot = this.nums[pivot_index];
        // 1. move pivot to end
        swap(pivot_index, right);
        int store_index = left;

        // 2. move all smaller elements to the left
        for (int i = left; i <= right; i++) {
            if (this.nums[i] < pivot) {
                swap(store_index, i);
                store_index++;
            }
        }

        // 3. move pivot to its final place
        swap(store_index, right);

        return store_index;
    }

    private int recur(int[] nums, int k, int p1, int p2) {

        if (p1 == p2)
            return nums[p1];

        Random r = new Random();
        int m = p1 + r.nextInt(p2-p1+1);
        //int m = p1;

        this.swap(nums, m, p1);

        int psmall = p1;
        int pmid = p1;
        int plarge = p2;
        int pivot = nums[m];

        while (pmid <= plarge) {

            if (nums[pmid] == pivot) {
                pmid ++;
            } else if (nums[pmid] < pivot) {
                this.swap(nums, pmid, psmall);
                pmid++;
                psmall++;
            } else {
                this.swap(nums, pmid, plarge);
                plarge--;
            }
        }

        //for (int i=p1; i<=p2; i++) {
        //    System.out.print(nums[i]+",");
        //}
        //System.out.println("k:"+k);

        if (plarge-p1+1 == k) {
            return nums[plarge];
        }

        if (plarge-p1+1 > k) {
            return recur(nums, k, p1, plarge-1);
        } else {
            return recur(nums, k- (plarge-p1+1), plarge+1, p2);
        }

    }

    private void swap(int[] nums, int p1, int p2) {
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }
}
