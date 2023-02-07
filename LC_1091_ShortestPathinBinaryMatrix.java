import java.util.*;

public class LC_1091_ShortestPathinBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] == 1 || grid[n-1][n-1] == 1)
            return -1;
        
        if (n == 1)
            return 1;
        
        int[][] cost = new int[n][n];
        cost[0][0] = 1;
        Set<String> visited = new HashSet<>();
        visited.add("0,0");
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        while (q.size() >0) {

            Queue<int[]> next = new LinkedList<>();

            while (q.size() > 0) {

                int[] p = q.poll();
                int x = p[0];
                int y = p[1];

                if (x-1>=0 && grid[x-1][y] == 0 && !visited.contains((x-1) + ","+y)) {
                    cost[x-1][y] = cost[x][y] + 1;
                    visited.add((x-1) + "," + y);
                    next.add(new int[]{x-1, y});
                }
                if (x-1>=0 && y+1<n && grid[x-1][y+1] == 0 && !visited.contains((x-1) + ","+(y+1))) {
                    cost[x-1][y+1] = cost[x][y] + 1;
                    visited.add((x-1) + "," + (y+1));
                    next.add(new int[]{x-1, y+1});
                }
                if (y+1<n && grid[x][y+1] == 0 && !visited.contains(x + ","+(y+1))) {
                    cost[x][y+1] = cost[x][y] + 1;
                    visited.add(x + "," + (y+1));
                    next.add(new int[]{x, y+1});
                }
                if (x+1<n && y+1<n && grid[x+1][y+1] == 0 && !visited.contains((x+1) + ","+(y+1))) {
                    cost[x+1][y+1] = cost[x][y] + 1;
                    visited.add((x+1) + "," + (y+1));
                    next.add(new int[]{x+1, y+1});
                }
                if (x+1<n && grid[x+1][y] == 0 && !visited.contains((x+1) + ","+y)) {
                    cost[x+1][y] = cost[x][y] + 1;
                    visited.add((x+1) + "," + y);
                    next.add(new int[]{x+1, y});
                }
                if (x+1<n && y-1 >=0 && grid[x+1][y-1] == 0 && !visited.contains((x+1) + ","+(y-1))) {
                    cost[x+1][y-1] = cost[x][y] + 1;
                    visited.add((x+1) + "," + (y-1));
                    next.add(new int[]{x+1, y-1});
                }
                if (y-1>=0 && grid[x][y-1] == 0 && !visited.contains(x + ","+(y-1))) {
                    cost[x][y-1] = cost[x][y] + 1;
                    visited.add(x + "," + (y-1));
                    next.add(new int[]{x, y-1});
                }
                if (x-1>=0 && y-1>=0 && grid[x-1][y-1] == 0 && !visited.contains((x-1) + ","+(y-1))) {
                    cost[x-1][y-1] = cost[x][y] + 1;
                    visited.add((x-1)+ "," + (y-1));
                    next.add(new int[]{x-1, y-1});
                }

            }

            q = next;

        }

        if (cost[n-1][n-1] == 0)
            return -1;

        return cost[n-1][n-1];
    }
}