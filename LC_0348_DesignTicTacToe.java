import java.util.*;

class LC_0348_DesignTicTacToe {

    //private int[][] board = null;
    private Map<Integer, Integer> rowsP1 = null;
    private Map<Integer, Integer> rowsP2 = null;
    private Map<Integer, Integer> colsP1 = null;
    private Map<Integer, Integer> colsP2 = null;
    private int cross1P1 = 0;
    private int cross2P1 = 0;
    private int cross1P2 = 0;
    private int cross2P2 = 0;
    private int board = 0;
    
    public LC_0348_DesignTicTacToe(int n) {
        //this.board = new int[n][n];
        this.board = n;
        this.rowsP1 = new HashMap<>();
        this.rowsP2 = new HashMap<>();
        this.colsP1 = new HashMap<>();
        this.colsP2 = new HashMap<>();  
    }
    
    public int move(int row, int col, int player) {
        
        if (player == 1) {
            if (this.rowsP1.containsKey(row))
                this.rowsP1.put(row, rowsP1.get(row) + 1);
            else
                this.rowsP1.put(row, 1);
            
            if (this.colsP1.containsKey(col))
                this.colsP1.put(col, colsP1.get(col) + 1);
            else
                this.colsP1.put(col, 1);
            
            if (row == col)
                this.cross1P1 ++;
            
            if (row + col + 1 == this.board)
                this.cross2P1 ++;
            
            if (this.rowsP1.get(row) == this.board 
                || this.colsP1.get(col) == this.board
                || this.cross1P1 == this.board
                || this.cross2P1 == this.board)
                return 1;
        } else {
            if (this.rowsP2.containsKey(row))
                this.rowsP2.put(row, rowsP2.get(row) + 1);
            else
                this.rowsP2.put(row, 1);
            
            if (this.colsP2.containsKey(col))
                this.colsP2.put(col, colsP2.get(col) + 1);
            else
                this.colsP2.put(col, 1);
            
            if (row == col)
                this.cross1P2 ++;
            
            if (row + col + 1 == this.board)
                this.cross2P2 ++;
            
            if (this.rowsP2.get(row) == this.board 
                || this.colsP2.get(col) == this.board
                || this.cross1P2 == this.board
                || this.cross2P2 == this.board)
                return 2;
        }
        
        return 0;
        
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */