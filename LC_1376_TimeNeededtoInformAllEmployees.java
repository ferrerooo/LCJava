import java.util.*;

public class LC_1376_TimeNeededtoInformAllEmployees {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        Map<Integer, Integer> timeMap = new HashMap<>();
        for (int i=0; i<n; i++)
            timeMap.put(i, informTime[i]);

        Map<Integer, Set<Integer>> employeeMap = new HashMap<>();
        for (int i=0; i<n; i++) {
            employeeMap.put(i, new HashSet<>());
        }
        for (int i=0; i<n; i++) {
            if (manager[i] != -1)
                employeeMap.get(manager[i]).add(i);
        }

        return dfs(headID, timeMap, employeeMap);
    }

    private int dfs(int id, Map<Integer, Integer> tmap, Map<Integer, Set<Integer>> emap) {

        if (tmap.get(id) == 0) {
            return 0;
        }

        int submax = 0;

        for (Integer sub : emap.get(id)) {
            int local = dfs(sub, tmap, emap);
            submax = Math.max(submax, local);
        }

        return submax + tmap.get(id);
    }
}