import java.util.*;

public class LC_0694_NumberofDistinctIslands {
    public int numDistinctIslands(int[][] grid) {

        Set<String> islands = new HashSet<>();

        int m = grid.length;
        int n = grid[0].length;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {

                if (grid[i][j] == 1) {
                    List<int[]> list = new ArrayList<>();
                    Set<String> visited = new HashSet<>();
                    dfs(grid, i, j, list, visited);
                    addToSet(islands, list);
                }               
            }
        }
        
        return islands.size();
    }

    private void dfs(int[][] grid, int row, int col, List<int[]> list, Set<String> visited) {

        if (onboard(grid, row, col) && grid[row][col] == 1 && !visited.contains(row+","+col)) {
            grid[row][col] = 2;
            visited.add(row+","+col);
            list.add(new int[]{row, col});
            dfs(grid, row+1, col, list, visited);
            dfs(grid, row-1, col, list, visited);
            dfs(grid, row, col+1, list, visited);
            dfs(grid, row, col-1, list, visited);
        }
    }

    private boolean onboard(int[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;

        if (row >=0 && row < m && col >=0 && col < n)
            return true;
        else
            return false;
    }

    private void addToSet(Set<String> islands, List<int[]> list) {

        Collections.sort(list, (x, y)-> {
            if (x[0] != y[0])
                return x[0]-y[0];
            else
                return x[1]-y[1];
        });

        int mx = list.get(0)[0];
        int my = list.get(0)[1];
        StringBuilder sb = new StringBuilder();

        for (int[] p : list) {
            sb.append(p[0]-mx);
            sb.append(",");
            sb.append(p[1]-my);
            sb.append(",");
        }

        islands.add(sb.toString());
    }
}