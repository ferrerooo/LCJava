class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> (x[0]*x[0]+x[1]*x[1]) - (y[0]*y[0]+y[1]*y[1]));

        for (int[] p : points)
            pq.offer(p);

        int size = Math.min(k, points.length);
        int[][] res = new int[size][2];

        for (int i=0; i<size; i++) {
            res[i] = pq.poll();
        }

        return res;
    }
}
