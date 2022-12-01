import java.util.*;

public class LC_0695_MaxAreaofIsland {

    public int maxAreaOfIsland(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int maxCnt = 0;
        
        for (int i = 0; i<m; i++) {
            for (int j=0;j<n; j++) {
                
                if (grid[i][j] == 1) {
                    
                    int count = this.updateAndCount(i, j, grid);
                    maxCnt = Math.max(maxCnt, count);
                }
            }
        }
        
        return maxCnt;
    }
    
    private int updateAndCount(int row, int col, int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        LinkedList<int[]> list = new LinkedList<>();
        list.offer(new int[]{row, col});
        int count = 0;
        
        while (list.size() > 0) {
            
            int[] point = list.pollFirst();
            if (grid[point[0]][point[1]] == 1) {
                grid[point[0]][point[1]] = 2;
                count ++;
                
                if (point[0]-1>=0 && grid[point[0]-1][point[1]] == 1)
                    list.offer(new int[]{point[0]-1, point[1]});
                
                if (point[0]+1 < m && grid[point[0]+1][point[1]] == 1)
                    list.offer(new int[]{point[0]+1, point[1]});
                
                if (point[1]-1 >= 0 && grid[point[0]][point[1]-1] == 1)
                    list.offer(new int[]{point[0], point[1]-1});
                
                if (point[1]+1 < n && grid[point[0]][point[1]+1] == 1)
                    list.offer(new int[]{point[0], point[1]+1});
            } 
        }
        
        return count;
    }
    
}
