class Solution {
    public int findBestValue(int[] arr, int target) {

        int maxNum = arr[0];
        int sum = 0;

        for (int i=0; i<arr.length; i++) {
            maxNum = Math.max(maxNum, arr[i]);
            sum += arr[i];
        }

        if (target >= sum) {
            return maxNum;
        }

        int p1 = 0; 
        int p2 = maxNum;

        int distance = Integer.MAX_VALUE;
        int result = 0;

        while (p1 <= p2) {
            int mid = p1 + (p2-p1)/2;

            int newSum = getNewSum(arr, mid);

            if (Math.abs(newSum-target) < distance) {
                distance = Math.abs(newSum-target);
                result = mid;

            } else if (Math.abs(newSum-target) == distance) {
                result = Math.min(result, mid);

            } 
            
            if (newSum > target) {
                p2 = mid-1;
            } else if (newSum == target){
                return mid;
            } else {
                p1 = mid+1;
            }
        }

        return result;
    }

    private int getNewSum(int[] arr, int mid) {
        int sum = 0;

        for (int i=0; i<arr.length; i++) {
            if (arr[i] < mid) {
                sum += arr[i];
            } else {
                sum += mid;
            }
        }

        return sum;
    }
}
