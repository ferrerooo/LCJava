import java.util.*;

public class LC_0403_FrogJump_my1 {
    public boolean canCross(int[] stones) {

        if (stones.length<2)
            return true;
        
        if (stones[1] != 1)
            return false;

        Map<Integer, Integer> stonemap = new HashMap<>();
        for (int i=0; i<stones.length; i++) {
            stonemap.put(stones[i], i);
        }

        int len = stones.length;
        
        return dfs(stonemap, 1, 1, len);
    }

    private Map<String, Boolean> cache = new HashMap<>();

    private boolean dfs(Map<Integer, Integer> map, int curStone, int preStep, int len) {

        if (cache.containsKey(curStone+","+preStep)) {
            return cache.get(curStone+","+preStep);
        }

        if (map.containsKey(curStone) && map.get(curStone) == len-1) {
            return true;
        }

        int op1 = preStep+1;
        int op2 = preStep;
        int op3 = preStep-1;

        if (map.containsKey(curStone+op1)) {
            if (dfs(map, curStone+op1, op1, len)) {
                cache.put(curStone+op1+","+op1, true);
                return true;
            }
        }

        if (map.containsKey(curStone+op2)) {
            if (dfs(map, curStone+op2, op2, len)) {
                cache.put(curStone+op2+","+op2, true);
                return true;
            }
        }

        if (map.containsKey(curStone+op3) && op3>0) {
            if (dfs(map, curStone+op3, op3, len)) {
                cache.put(curStone+op3+","+op3, true);
                return true;
            }
        }

        cache.put(curStone+","+preStep, false);

        return false;
    }
}