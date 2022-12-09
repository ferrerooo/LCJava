import java.util.*;

public class LC_0200_NumberofIslands {

    public int numIslands(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        int count = 0;
        
        for (int i = 0; i<m ;i++) {
            for (int j=0; j<n; j++) {
                
                if (grid[i][j] == '1')
                    count++;
                    this.detect(i, j, grid);
            }
        }
        
        return count;
    }
    
    private void detect(int row, int col, char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        LinkedList<int[]> list = new LinkedList<>();
        int[] point = {row, col};
        list.offer(point);
        
        while (list.size() > 0) {
            
            int[] cur = list.pollFirst();
            if (grid[cur[0]][cur[1]] == '1') {
                grid[cur[0]][cur[1]] = '2';
            } else {
                continue;
            }
            
            if (cur[0]-1 >= 0 && grid[cur[0]-1][cur[1]] == '1') {
                list.offer(new int[]{cur[0]-1, cur[1]});
            }
            
            if (cur[0]+1 < m && grid[cur[0]+1][cur[1]] == '1') {
                list.offer(new int[]{cur[0]+1, cur[1]});
            }
            
            if (cur[1]-1 >= 0 && grid[cur[0]][cur[1]-1] == '1') {
                list.offer(new int[]{cur[0], cur[1]-1});
            }
            
            if (cur[1]+1 < n && grid[cur[0]][cur[1]+1] == '1') {
                list.offer(new int[]{cur[0], cur[1]+1});
            }
        }
    }
    
}
