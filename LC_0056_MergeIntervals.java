class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (x,y)->x[0]-y[0]);

        List<int[]> res = new ArrayList<>();

        int[] arr1 = intervals[0];
        int p = 1;

        while (p < intervals.length) {

            int[] arr2 = intervals[p];
            if (arr1[1]>=arr2[0]) {
                arr1[1] = Math.max(arr1[1],arr2[1]);
            } else {
                res.add(arr1);
                arr1 = arr2;
            }
            p++;
        }

        res.add(arr1);

        int[][] results = new int[res.size()][2];
        for (int i=0;i<res.size();i++) {
            results[i] = res.get(i);
        }

        return results;
    }
}
