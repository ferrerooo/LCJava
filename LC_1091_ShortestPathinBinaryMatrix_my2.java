import java.util.*;

public class LC_1091_ShortestPathinBinaryMatrix_my2 {
    
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) {
            return -1;
        }

        Set<int[]> cur = new HashSet<>();
        Set<int[]> next = new HashSet<>();
        Set<String> visited = new HashSet<>();
        cur.add(new int[]{0,0});
        visited.add("0,0");

        int step = 1;

        if (visited.contains((n-1)+","+(n-1)))
            return step;

        while (cur.size() > 0) {

            for (int[] current : cur) {

                int r = current[0];
                int l = current[1];

                if (onbard(grid, r, l+1) && grid[r][l+1] == 0 && !visited.contains(r+","+(l+1))) {
                    next.add(new int[]{r, l+1});
                    visited.add(r+","+(l+1));
                }
                if (onbard(grid, r+1, l+1) && grid[r+1][l+1] == 0 && !visited.contains((r+1)+","+(l+1))) {
                    next.add(new int[]{r+1, l+1});
                    visited.add((r+1)+","+(l+1));
                }
                if (onbard(grid, r+1, l) && grid[r+1][l] == 0 && !visited.contains((r+1)+","+l)) {
                    next.add(new int[]{r+1, l});
                    visited.add((r+1)+","+(l));
                }

                if (onbard(grid, r+1, l-1) && grid[r+1][l-1] == 0 && !visited.contains(r+1+","+(l-1))) {
                    next.add(new int[]{r+1, l-1});
                    visited.add((r+1)+","+(l-1));
                }
                if (onbard(grid, r, l-1) && grid[r][l-1] == 0 && !visited.contains(r+","+(l-1))) {
                    next.add(new int[]{r, l-1});
                    visited.add((r)+","+(l-1));
                }
                if (onbard(grid, r-1, l-1) && grid[r-1][l-1] == 0 && !visited.contains(r-1+","+(l-1))) {
                    next.add(new int[]{r-1, l-1});
                    visited.add((r-1)+","+(l-1));
                }
                if (onbard(grid, r-1, l) && grid[r-1][l] == 0 && !visited.contains(r-1+","+(l))) {
                    next.add(new int[]{r-1, l});
                    visited.add((r-1)+","+(l));
                }
                if (onbard(grid, r-1, l+1) && grid[r-1][l+1] == 0 && !visited.contains(r-1+","+(l+1))) {
                    next.add(new int[]{r-1, l+1});
                    visited.add((r-1)+","+(l+1));
                }
            }

            step++;

            if (visited.contains((n-1)+","+(n-1))) {
                return step;
            }

            cur = next;
            next = new HashSet<>();

        }

        return -1;
         
    }

    private boolean onbard(int[][] grid, int r, int l) {
        int n = grid.length;

        return r >=0 && r < n && l >=0 && l < n;
    }
}