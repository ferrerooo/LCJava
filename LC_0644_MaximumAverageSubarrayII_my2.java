import java.util.*;

public class LC_0644_MaximumAverageSubarrayII_my2 {
    
    public double findMaxAverage(int[] nums, int k) {
        
        double esp = 1E-5;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i : nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        double p1 = min;
        double p2 = max;

        List<Double> list = new ArrayList<>();
        double res;

        while (list.size() < 2 || Math.abs(list.get(0)-list.get(1)) > esp) {

            double mid = p1 + (p2-p1)/2;

            if (isExistSubSet(nums, k, mid)) {
                list.add(mid);
                p1 = mid;
            } else {
                p2 = mid;
            }

            if (list.size() > 2) {
                list.remove(0);
            }
        }

        return list.get(1);

    }

    private boolean isExistSubSet(int[] nums, int k, double mid) {

        double[] arr = new double[nums.length];
        for (int i=0; i<arr.length; i++) {
            arr[i] = nums[i] - mid;
        }

        double sum = 0;
        for (int i=0; i<k; i++) {
            sum += arr[i];
        }

        if (sum >=0) {
            return true;
        }

        double presummin = arr[0];
        double presum = 0;

        for (int i=k; i<nums.length; i++) {

            sum += arr[i];
            presum += arr[i-k];
            presummin = Math.min(presummin, presum);

            if (sum - presummin >=0)
                return true;
        }

        return false;

    }
}