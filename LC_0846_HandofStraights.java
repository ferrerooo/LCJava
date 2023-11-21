class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0)
            return false;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i:hand) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        int groupCnt = hand.length / groupSize;

        for (int i=0; i<groupCnt; i++) {
            System.out.println(map.size());
            int minKey = map.firstKey();
            map.put(minKey, map.get(minKey)-1);
            if (map.get(minKey) == 0)
                map.remove(minKey);
            
            for (int j=1; j<groupSize; j++) {
                int next = minKey+j;
                if (!map.containsKey(next))
                    return false;
                else {
                    map.put(next, map.get(next)-1);
                    if (map.get(next) == 0)
                        map.remove(next);
                }
            }

        }

        return true;
        
    }
}
