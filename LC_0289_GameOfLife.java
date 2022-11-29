class LC_0289_GameOfLife {
    
    private static final int ZEROTOZERO = 10;
    private static final int ZEROTOONE = 11;
    private static final int ONETOZERO = 20;
    private static final int ONETOONE = 21;
    
    public void gameOfLife(int[][] board) {
        
        int m = board.length;
        int n = board[0].length;
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                
                this.updateBoard(board, i, j);    
            }
        }
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                switch (board[i][j]) {
                    case ZEROTOZERO:
                    case ONETOZERO:
                        board[i][j] = 0;
                        break;
                    case ZEROTOONE:
                    case ONETOONE:
                        board[i][j] = 1;
                        break;
                    default:
                        break;
                }
                
            }
        }
    }
    
    private void updateBoard(int[][] board, int row, int col) {
        
        int m = board.length;
        int n = board[0].length;
        
        int countOne = 0;
        
        // 1
        if (row-1 >= 0 && col-1 >= 0) {
            if (board[row-1][col-1] == 1 
                || board[row-1][col-1] == ONETOZERO
                || board[row-1][col-1] == ONETOONE) {
                countOne += 1;
            } 
        }
        
        // 2
        if (row-1 >= 0) {
            if (board[row-1][col] == 1 
                || board[row-1][col] == ONETOZERO
                || board[row-1][col] == ONETOONE) {
                countOne += 1;
            } 
        }
        
        // 3
        if (row-1 >= 0 && col+1 < n) {
            if (board[row-1][col+1] == 1 
                || board[row-1][col+1] == ONETOZERO
                || board[row-1][col+1] == ONETOONE) {
                countOne += 1;
            } 
        }
        
        // 4
        if (col+1 < n) {
            if (board[row][col+1] == 1 
                || board[row][col+1] == ONETOZERO
                || board[row][col+1] == ONETOONE) {
                countOne += 1;
            } 
        }
        
        // 5
        if (row+1 < m && col+1 < n) {
            if (board[row+1][col+1] == 1 
                || board[row+1][col+1] == ONETOZERO
                || board[row+1][col+1] == ONETOONE) {
                countOne += 1;
            } 
        }
        
        // 6
        if (row+1 < m) {
            if (board[row+1][col] == 1 
                || board[row+1][col] == ONETOZERO
                || board[row+1][col] == ONETOONE) {
                countOne += 1;
            } 
        }
        
        // 7
        if (row+1 < m && col-1 >= 0) {
            if (board[row+1][col-1] == 1 
                || board[row+1][col-1] == ONETOZERO
                || board[row+1][col-1] == ONETOONE) {
                countOne += 1;
            } 
        }
        
        // 8
        if (col-1 >= 0) {
            if (board[row][col-1] == 1 
                || board[row][col-1] == ONETOZERO
                || board[row][col-1] == ONETOONE) {
                countOne += 1;
            } 
        }
        
        if (board[row][col] == 0) {
            if (countOne == 3) {
                board[row][col] = ZEROTOONE;
            } else {
                board[row][col] = ZEROTOZERO;
            }
        }
        
        if (board[row][col] == 1) {
            if (countOne < 2 || countOne > 3) {
                board[row][col] = ONETOZERO;
            } else {
                board[row][col] = ONETOONE;
            }
        }
    }
}