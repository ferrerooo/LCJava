public class LC_101_CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        
        int sum = 0;
        int max = 0;
        int result = Integer.MAX_VALUE;

        for (int i:weights) {
            sum += i;
            max = Math.max(max, i);
        }

        int p1 = max;
        int p2 = sum;

        while (p1 <= p2) {
            int mid = p1 + (p2-p1)/2;

            int localDay = 0;
            int capacity = 0;
            for (int i=0; i<weights.length; i++) {

                if (capacity + weights[i] <= mid) {
                    capacity += weights[i];
                    continue;
                } else {
                    localDay++;
                    capacity = 0;
                    i--;
                }
            }
            localDay++;
            //System.out.println(localDay + ","+ mid);
            
            if (localDay == days) {
                p2 = mid-1;
                result = Math.min(result, mid);
            } else if (localDay > days) {
                p1 = mid+1;
            } else {
                p2 = mid-1;
                result = Math.min(result, mid);
            }
        }

        return result;
    }
}