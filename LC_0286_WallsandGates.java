import java.util.*;

public class LC_0286_WallsandGates {
    
    public void wallsAndGates(int[][] rooms) {
        
        Set<String> cur = new HashSet<>();
        Set<String> next = new HashSet<>();

        int step=0;

        int m = rooms.length;
        int n = rooms[0].length;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (rooms[i][j] == 0) {
                    cur.add(i+","+j);
                }
            }
        }


        while (cur.size() > 0) {

            for (String p : cur) {
                
                int x = Integer.valueOf(p.split(",")[0]);
                int y = Integer.valueOf(p.split(",")[1]);
                
                if (rooms[x][y] == 2147483647 || rooms[x][y] == 0) {
                    rooms[x][y] = step;
                }
                else{
                    continue;
                }

                if (onboard(rooms, x+1, y) && rooms[x+1][y] == 2147483647) {
                    next.add((x+1) + "," + y);
                }

                if (onboard(rooms, x-1, y) && rooms[x-1][y] == 2147483647) {
                    next.add((x-1) + "," + y);
                }

                if (onboard(rooms, x, y+1) && rooms[x][y+1] == 2147483647) {
                    next.add((x) + "," + (y+1));
                }

                if (onboard(rooms, x, y-1) && rooms[x][y-1] == 2147483647) {
                    next.add((x) + "," + (y-1));
                }

            }

            step++;
            cur = next;
            next = new HashSet<>();

        }

        return;
    }

    private boolean onboard(int[][] rooms, int x, int y) {
        int m = rooms.length;
        int n = rooms[0].length;

        return x>=0 && x<m && y>=0 && y<n;
    }
}