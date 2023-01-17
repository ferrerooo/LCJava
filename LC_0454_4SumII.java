import java.util.*;

public class LC_0454_4SumII {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        
        int result = 0;
        int n = nums1.length;

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i<n; i++) {
            for (int j=0; j<n; j++) {
                int sum = nums1[i] + nums2[j];
                if (!map1.containsKey(sum)) {
                    map1.put(sum, 1);
                } else {
                    map1.put(sum, map1.get(sum) + 1);
                }
            }
        }

        for (int i = 0; i<n; i++) {
            for (int j=0; j<n; j++) {
                int sum = nums3[i] + nums4[j];
                if (!map2.containsKey(sum)) {
                    map2.put(sum, 1);
                } else {
                    map2.put(sum, map2.get(sum) + 1);
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {

            int part = 0 - entry.getKey();

            if (map2.containsKey(part)) {
                result = result + map2.get(part) * entry.getValue();
            }

        }

        return result;

    }
}