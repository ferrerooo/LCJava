import java.util.*;

public class LC_0877_StoneGame_MinMax {

    Map<String, Integer> map = new HashMap<>();

    public boolean stoneGame(int[] piles) {
        
        int n = piles.length;

        return score(piles, 0, n-1) > 0;
    }

    // assume person A is going to move. score() function returns the relative score that when person A and B do the best move, what A's relative score is
    private int score(int[] piles, int p1, int p2) {

        if (map.containsKey(p1+","+p2)) {
            return map.get(p1+","+p2);
        }

        if (p1 > p2)
            return 0;
        
        if (p1 == p2)
            return piles[p1];
        
        int s1 = 0;
        if (map.containsKey((p1+1)+","+p2)) {
            s1 = map.get((p1+1)+","+p2);
        } else {
            s1 = score(piles, p1+1, p2);
            map.put((p1+1)+","+p2, s1);
        }

        int s2 = 0;
        if (map.containsKey(p1+","+(p2-1))) {
            s2 = map.get(p1+","+(p2-1));
        } else {
            s2 = score(piles, p1, p2-1);
            map.put(p1+","+(p2-1), s2);
        }

        
        return Math.max(piles[p1] - score(piles, p1+1, p2), piles[p2] - score(piles, p1, p2-1));

    }
}