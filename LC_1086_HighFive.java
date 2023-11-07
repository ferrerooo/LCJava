class Solution {
    public int[][] highFive(int[][] items) {

        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int[] item : items) {

            int id = item[0];
            int score = item[1];
            //System.out.println("init-id:"+id + "score:"+score);
            if (!map.containsKey(id)) 
                map.put(id, new PriorityQueue<Integer>((x,y)->y-x));
            map.get(id).offer(score);
            //System.out.println("id:"+id + "score:"+score);
        }


        int[][] res = new int[map.size()][2];
        int index = 0;
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {

            res[index][0] = entry.getKey();
            PriorityQueue<Integer> pqueue = entry.getValue();
            //System.out.println("id:"+res[index][0]+", score size:"+pqueue.size());
            
            int sum = 0;
            for(int i=0; i<5; i++) {
                int score = pqueue.poll();
                sum = sum + score;
            }

            res[index][1] = sum/5;
            index++;
        }

        Arrays.sort(res, (x,y)->(x[0]-y[0]));
        
        return res;
    }
}
