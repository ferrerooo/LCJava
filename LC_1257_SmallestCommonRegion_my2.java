import java.util.*;

public class LC_1257_SmallestCommonRegion_my2 {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {

        Map<String, String> map = new HashMap<>();

        for (List<String> list : regions) {
            String value = list.get(0);
            for (int i=1; i<list.size(); i++) {
                map.put(list.get(i), value);
            }
        }
        
        Set<String> parents = new HashSet<>();

        String a = region1;
        parents.add(a);
        while (map.containsKey(a)) {
            a = map.get(a);
            parents.add(a);
        }
        parents.add(a);

        String b = region2;
        while (!parents.contains(b)) {
            b = map.get(b);
        }

        return b;
    }
}