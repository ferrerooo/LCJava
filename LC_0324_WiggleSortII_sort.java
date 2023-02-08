import java.util.*;

public class LC_0324_WiggleSortII_sort {
    public void wiggleSort(int[] nums) {
        
        Arrays.sort(nums);

        int m =0;
        if (nums.length % 2 == 0) {
            m = nums.length/2 - 1;
        } else {
            m = nums.length/2;
        }

        int p1 = m;
        int p2 = nums.length-1;

        List<Integer> res = new ArrayList<>();

        while (p2 > m) {
            res.add(nums[p1]);
            p1--;
            res.add(nums[p2]);
            p2--;
        }

        if (p1 == 0)
         res.add(nums[p1]);

        for (int i=0; i<res.size(); i++) {
            nums[i] = res.get(i);
        }

    }
}