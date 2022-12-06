import java.util.*;

class LC_2171_RemovingMinimumNumberofMagicBeans {
    public long minimumRemoval(int[] beans) {

        long[] sum = new long[beans.length];
        Arrays.sort(beans);
        sum[0] = beans[0];
        for (int i=1; i<beans.length; i++) {
            sum[i] = sum[i-1] + beans[i];
        }
        
        long result = sum[beans.length-1];

        for (int i=0; i<beans.length; i++) {

            if (i == 0) {
                result = Math.min(sum[beans.length-1] - (beans.length-i) * sum[i], result);
                continue;
            }

            result = Math.min(result, sum[i-1] + sum[beans.length-1] - sum[i] - (beans.length -i-1 )*beans[i]);
        }

        return result;
    }
}