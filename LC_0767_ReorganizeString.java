import java.util.*;

public class LC_0767_ReorganizeString {
    
    public String reorganizeString(String s) {
        
        Map<Character, Integer> map = new HashMap<>();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((x,y)-> {
            if (x.num != y.num)
                return y.num - x.num;
            else
                return x.c - y.c;
        });

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(new Node(entry.getKey(), entry.getValue()));
        }

        StringBuilder sb = new StringBuilder();

        while (pq.size() > 0) {

            Node n1 = pq.poll();

            Node n2 = null;
            if (pq.size()>0)
                n2 = pq.poll();
            else {
                if (n1.num>1)
                    return "";
                else {
                    sb.append(n1.c);
                    break;
                }
            }

            sb.append(n1.c);
            sb.append(n2.c);

            n1.num = n1.num-1;
            n2.num = n2.num-1;

            if (n1.num > 0)
                pq.offer(n1);
            
            if (n2.num > 0)
                pq.offer(n2);
        }

        return sb.toString();
    }

    class Node {
        public Node(char _c, int _num) {
            c = _c;
            num = _num;
        }
        public char c;
        public int num;
    }
}