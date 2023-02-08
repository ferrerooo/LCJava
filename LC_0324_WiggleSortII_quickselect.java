import java.util.*;

public class LC_0324_WiggleSortII_quickselect {
    public void wiggleSort(int[] nums) {
        
        int k = 0;

        if (nums.length %2 == 1) {
            k = nums.length/2+1;
        } else {
            k = nums.length/2;
        }

        int midVal = findK (nums, 0, nums.length-1, k);

        separate(nums, 0, nums.length-1, midVal);

        List<Integer> res = new ArrayList<>();

        int p1 = k-1;
        int p2 = nums.length-1;

        while (p2 > k-1) {
            res.add(nums[p1]);
            res.add(nums[p2]);
            p2--;
            p1--;
        }

        if (p1 == 0)
            res.add(nums[p1]);

        for (int i=0; i<res.size(); i++) {
            nums[i] = res.get(i);
        }

    }

    private int findK (int[] nums, int start, int end, int k) {

        if (start == end) {
            return nums[start];
        }

        int pivot = nums[start];
        int index = separate(nums, start, end, pivot);
        int nth = index-start+1;

        if (nth == k) {
            return pivot;
        } else if (nth > k) {
            return findK(nums, start, index-1, k);
        } else {
            return findK(nums, index+1, end, k-nth);
        }
    }

    private int separate(int[] nums, int start, int end, int pivot) {

        int p1 = start;
        int p2 = start;
        int p3 = end;

        while (p2<=p3) {

            if (nums[p2] == pivot) {
                p2++;
            } else if (nums[p2] < pivot) {
                swap(nums, p1, p2);
                p1++;
                p2++;
            } else {
                swap(nums, p2, p3);
                p3--;
            }
        }

        return p1;
    }

    private void swap(int[] nums, int p1, int p2) {
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }
}