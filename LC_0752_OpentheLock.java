import java.util.*;

public class LC_0752_OpentheLock {
    public int openLock(String[] deadends, String target) {

        Set<String> deads = new HashSet<>();
        for (String s : deadends)
            deads.add(s);

        if (deads.contains("0000"))
            return -1;
        
        if (target.equals("0000"))
            return 0;
        
        Map<String, Integer> map = new HashMap<>();
        map.put("0000", 0);

        Queue<String> q = new LinkedList<>();
        q.offer("0000");

        while (q.size() >0) {

            String index = q.poll();
            List<String> nexts = this.getNexts(index, deads);

            for (String next: nexts) {

                if (!map.containsKey(next)) {
                    map.put(next, map.get(index)+1);
                    if (target.equals(next))
                        return map.get(next);
                    q.offer(next);
                } 
            }
        }

        return -1;
    }

    private List<String> getNexts(String index, Set<String> deads) {

        List<String> list = new LinkedList<>();
        int n0 = index.charAt(0) - '0';
        int n1 = index.charAt(1) - '0';
        int n2 = index.charAt(2) - '0';
        int n3 = index.charAt(3) - '0';

        int n0_1 = (n0+1)%10;
        int n0_2 = (n0-1+10)%10;
        list.add(n0_1 + String.valueOf(n1) + String.valueOf(n2) + String.valueOf(n3));
        list.add(n0_2 + String.valueOf(n1) + String.valueOf(n2) + String.valueOf(n3));
        
        int n1_1 = (n1+1)%10;
        int n1_2 = (n1-1+10)%10;
        list.add(String.valueOf(n0) + n1_1 + String.valueOf(n2) + String.valueOf(n3));
        list.add(String.valueOf(n0) + n1_2 + String.valueOf(n2) + String.valueOf(n3));

        int n2_1 = (n2+1)%10;
        int n2_2 = (n2-1+10)%10;
        list.add(String.valueOf(n0) + String.valueOf(n1) + n2_1 + String.valueOf(n3));
        list.add(String.valueOf(n0) + String.valueOf(n1) + n2_2 + String.valueOf(n3));

        int n3_1 = (n3+1)%10;
        int n3_2 = (n3-1+10)%10;
        list.add(String.valueOf(n0) + String.valueOf(n1) + String.valueOf(n2) + n3_1);
        list.add(String.valueOf(n0) + String.valueOf(n1) + String.valueOf(n2) + n3_2);

        List<String> nexts = new LinkedList<>();

        for (String s:list) {
            if (!deads.contains(s))
                nexts.add(s);
        }

        return nexts;
    }
}