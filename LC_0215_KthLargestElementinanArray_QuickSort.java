import java.util.*;

public class LC_0215_KthLargestElementinanArray_QuickSort {

    public int findKthLargest(int[] nums, int k) {

        return recur(nums, nums.length-k+1, 0, nums.length-1);
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
    
}
