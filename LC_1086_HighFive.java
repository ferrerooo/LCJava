class Solution {
    public int[][] highFive(int[][] items) {

        Map<Integer, PriorityQueue<Integer>> idScoresMap = new HashMap<>();

        for (int[] item : items) {

            if (idScoresMap.containsKey(item[0])) {
                idScoresMap.get(item[0]).offer(item[1]);
            } else {
                PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x,y)->(y-x));
                pq.offer(item[1]);
                idScoresMap.put(item[0], pq);
            }
        }

        int[][] results = new int[idScoresMap.size()][2];
        int index = 0;

        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : idScoresMap.entrySet()) {

            results[index][0] = entry.getKey();
            results[index][1] = getTop5Avg(entry.getValue());

            index++;
        }

        return results;
        
    }

    private int getTop5Avg(PriorityQueue<Integer> pq) {

        int sum = 0;
        for (int i=0;i<5;i++) {
            sum += pq.poll();
        }

        return sum/5;

    }
}
