import java.util.*;

public class LC_1257_SmallestCommonRegion_my1 {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        
        Map<String, String> map = new HashMap<>();

        for (List<String> list : regions) {
            String value = list.get(0);
            for (int i=1; i<list.size(); i++) {
                map.put(list.get(i), value);
            }
        }

        String r1 = region1;
        List<String> parents1 = new ArrayList<>();
        parents1.add(r1);
        String r2 = region2;
        List<String> parents2 = new ArrayList<>();
        parents2.add(r2);

        while (map.containsKey(r1)) {
            r1 = map.get(r1);
            parents1.add(r1);
        }

        while (map.containsKey(r2)) {
            r2 = map.get(r2);
            parents2.add(r2);
        }

        String res = "";

        int p1 = parents1.size()-1;
        int p2 = parents2.size()-1;

        

        while (p1 >=0 && p2 >=0) {
            if (parents1.get(p1).equals(parents2.get(p2))) {
                
                res = parents1.get(p1);
                p1--;
                p2--;
            } else {
                break;
            }
        }

        return res;
    }
}