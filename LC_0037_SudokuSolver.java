import java.util.*;

public class LC_0037_SudokuSolver {
    public void solveSudoku(char[][] board) {       
        dfs(board);
    }

    public boolean dfs(char[][] board) {

        for (int i=0; i<9; i++) {
            for (int j=0;j<9;j++) {

                if (board[i][j] == '.') {
                    for (char c = '1'; c<='9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (dfs(board)) {
                                return true;
                            }
                        }                                
                    }

                    board[i][j] = '.';
                    return false;
                }

            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {


        Set<Character> rowSet = new HashSet<>();
        Set<Character> colSet = new HashSet<>();
        Set<Character> gridSet = new HashSet<>();

        for (int i=0; i<9; i++) {
            rowSet.add(board[row][i]);
        }
        if (rowSet.contains(c))
            return false;
        
        for (int i=0; i<9; i++) {
            colSet.add(board[i][col]);
        }
        if (colSet.contains(c))
            return false;
        
        int x = (row/3) * 3;
        int y = (col/3) * 3;

        for (int i=x; i<x+3; i++) {
            for (int j=y; j<y+3; j++) {
                gridSet.add(board[i][j]);
            }
        }
        if (gridSet.contains(c))
            return false;
        
        return true;
    }
}