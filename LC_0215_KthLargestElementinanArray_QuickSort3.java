class Solution {
    public int findKthLargest(int[] nums, int k) {

        return recur(nums, 0, nums.length-1, k);
        
    }

    private int recur(int[] nums, int p1, int p2, int k) {

        if (p1 == p2) {
            return nums[p1];
        }

        int pRandom = getRandom(p1, p2);
        swap(nums, p1, pRandom);

        int pPartition = partition(nums, p1, p2);

        if (pPartition - p1 + 1 == k) {
            return nums[pPartition];
        } else if (pPartition - p1 + 1 > k) {
            return recur(nums, p1, pPartition-1, k);
        } else {
            return recur(nums, pPartition+1, p2, k - (pPartition-p1+1));
        }
    }

    private int partition(int[] nums, int p1, int p2) {
        int pivot = nums[p1];

        while (p1 < p2) {

            while (p1 < p2 && nums[p2] <= pivot) 
                p2--;
            
            nums[p1] = nums[p2];

            while (p1 < p2 && nums[p1] >= pivot)
                p1++;
            
            nums[p2] = nums[p1];
        }

        nums[p1] = pivot;
        return p1;
    }

    private void swap(int[] nums, int p1, int p2) {
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }

    private int getRandom(int p1, int p2) {
        Random rand = new Random();
        int pRandom = rand.nextInt(p2 - p1 + 1);
        return p1 + pRandom;
    }
}
