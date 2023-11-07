class Solution {
    public String reorganizeString(String s) {

        Map<Character, Integer> charCountMap = new HashMap<>();

        char[] charArr = s.toCharArray();

        for (char c : charArr) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((x,y)->{
            if (x.count != y.count) {
                return y.count - x.count;
            } else {
                return x.c - y.c;
            }
        });

        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            pq.offer(new Node(entry.getKey(), entry.getValue()));
        }

        StringBuilder sb = new StringBuilder();

        while (pq.size() > 1) {

            Node node1 = pq.poll();
            Node node2 = pq.poll();

            sb.append(node1.c);
            sb.append(node2.c);

            node1.count--;
            node2.count--;

            if (node1.count > 0)
                pq.offer(node1);
            
            if (node2.count > 0)
                pq.offer(node2);

        }

        if (pq.size() == 0)
            return sb.toString();
        
        if (pq.peek().count > 1)
            return "";
        
        sb.append(pq.peek().c);

        return sb.toString();
        
    }

    class Node {
        char c;
        int count;

        public Node(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
}
