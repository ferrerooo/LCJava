

class LC_0644_MaximumAverageSubarrayII {
    public double findMaxAverage(int[] nums, int k) {
        
        double esp = 1E-5;

        int min = nums[0];
        int max = nums[0];

        for (int i=1; i<nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        double mind = (double)min;
        double maxd = (double)max;

        while (Math.abs(maxd-mind) > esp) {

            double m = mind + (maxd-mind)/2;

            if (this.check(nums, k, m)) {
                mind = m;
            } else {
                maxd = m;
            }
        }

        return mind;
    }

    private boolean check(int[] nums, int k, double avg) {

        double[] arr = new double[nums.length];
        for (int i=0;i<nums.length; i++) {
            arr[i] = nums[i]-avg;
        }

        double sum = 0;
        for (int i=0;i<k;i++) {
            sum = sum + arr[i];
        }

        if (sum >=0)
            return true;

        double presum = 0;
        double premin = arr[0];
        for (int i=k; i<nums.length; i++) {

            sum = sum + arr[i];
            presum = presum + arr[i-k];
            premin = Math.min(premin, presum);
            if (sum - premin >=0)
                return true;
        }

        return false;
    }
}