package Google;

import java.util.*;

public class LC_284_BrickNWall {
    
    static final int M = (int)(1e9+7);

    static public int buildWall(int height, int width, int[] bricks) {

        int jointPoints = width - 1;
        
        List<Integer> states = new ArrayList<>();

        Set<Integer> brickSet = new HashSet<>();
        for (Integer i : bricks)
            brickSet.add(i);

        for (int state = 0; state < (1 << jointPoints); state++) {

            var list = new ArrayList<Integer>();
            list.add(-1);

            for (int i = 0; i < jointPoints; i++) {
                if ( ((state>>i) & 1) == 1) {
                    list.add(i);
                }
            }

            list.add(jointPoints);

            boolean isValid = true;

            for (int i = 0; i < list.size()-1; i++) {
                var aBrick = list.get(i+1) - list.get(i);
                if (!brickSet.contains(aBrick)) {
                    isValid = false;
                }
            }

            if (isValid)
                states.add(state);
        }

        var dp = new int[height][states.size()];

        for (int i = 0; i < states.size(); i++)
            dp[0][i] = 1;
        
        for (int i = 1; i < height; i++) {
            for (int j = 0; j < states.size(); j++) {
                for (int k = 0; k < states.size(); k++) {
                    if ((states.get(j) & states.get(k)) == 0) {
                        dp[i][j] = (dp[i][j] + dp[i-1][k]) % M;
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < states.size(); i++) {
            result = (result + dp[height-1][i]) % M;
        }

        return result;
    }

    public static void main1() {

        int height = 76;
        int width = 9;
        int[] bricks = new int[]{6,3,5,1,9};
        int r = buildWall(height, width, bricks);

        System.out.println(r);
    }
}