public class LC_0755_PourWater {
    public int[] pourWater(int[] heights, int volume, int k) {

        for (int i=0; i<volume; i++) {

            int localMin = heights[k];
            int localMinIndex = k;

            for (int j=k-1; j>=0; j--) {
                if (heights[j] < localMin) {
                    localMin = heights[j];
                    localMinIndex = j;
                } else if (heights[j] == localMin) {
                    continue;
                } else {
                    break;
                }
            }

            if (localMinIndex < k) {
                heights[localMinIndex]++;
                continue;
            }

            for (int j=k+1; j<heights.length; j++) {
                if (heights[j] < localMin) {
                    localMin = heights[j];
                    localMinIndex = j;
                } else if (heights[j] == localMin) {
                    continue;
                } else {
                    break;
                }
            }

            if (localMinIndex > k) {
                heights[localMinIndex]++;
                continue;
            }

            heights[k]++;
        }
        
        return heights;
    }
}