import java.util.*;

public class LC_0130_SurroundedRegions {
    public void solve(char[][] board) {
        
        int m = board.length;
        int n = board[0].length;

        for (int i=0; i<m; i++) {
            if (board[i][0] == 'O')
                this.updateRegion(board, i, 0);
            
            if (board[i][n-1] == 'O')
                this.updateRegion(board, i, n-1);
        }

        for (int i=0; i<n; i++) {
            if (board[0][i] == 'O')
                this.updateRegion(board, 0, i);
            
            if (board[m-1][i] == 'O')
                this.updateRegion(board, m-1, i);
        }

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == 'Y')
                    board[i][j] = 'O';
            }
        }
        
        return;
    }

    private void updateRegion(char[][] board, int row, int col) {

        int m = board.length;
        int n = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});

        while (!q.isEmpty()) {

            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            if (board[x][y] == 'Y')
                continue;
            
            board[x][y] = 'Y';

            if (x-1>=0 && board[x-1][y] == 'O')
                q.offer(new int[]{x-1, y});
            if (x+1<m && board[x+1][y] == 'O')
                q.offer(new int[]{x+1, y});
            if (y-1>=0 && board[x][y-1] == 'O')
                q.offer(new int[]{x, y-1});
            if (y+1<n && board[x][y+1] == 'O')
                q.offer(new int[]{x, y+1});
        }

    }
}