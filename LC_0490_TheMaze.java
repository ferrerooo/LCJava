import java.util.*;

public class LC_0490_TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        Set<String> visited = new HashSet<>();
        int m = maze.length;
        int n = maze[0].length;

        if (maze[start[0]][start[1]] == 1)
            return false;
        
        if (maze[destination[0]][destination[1]] == 1)
            return false;
        
        if (start[0] == destination[0] && start[1] == destination[1])
            return true;
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);

        while (q.size() > 0) {

            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            String key = String.valueOf(x) + "," + String.valueOf(y);
            if (visited.contains(key))
                continue;
            
            if (x == destination[0] && y == destination[1])
                return true;

            visited.add(key);

            // up
            int curX = x;
            while (curX-1>=0 && maze[curX-1][y]==0) {
                curX--;
            }
            if (!visited.contains(String.valueOf(curX) + "," + String.valueOf(y)))
                q.offer(new int[]{curX, y});
            
            // down
            curX = x;
            while (curX+1<m && maze[curX+1][y]==0) {
                curX++;
            }
            if (!visited.contains(String.valueOf(curX) + "," + String.valueOf(y)))
                q.offer(new int[]{curX, y});
            
            // left
            int curY = y;
            while (curY-1>=0 && maze[x][curY-1]==0) {
                curY--;
            }
            if (!visited.contains(String.valueOf(x) + "," + String.valueOf(curY)))
                q.offer(new int[]{x, curY});
            
            // right
            curY = y;
            while (curY+1<n && maze[x][curY+1]==0) {
                curY++;
            }
            if (!visited.contains(String.valueOf(x) + "," + String.valueOf(curY)))
                q.offer(new int[]{x, curY});
        }
        
        return false;
    }


}