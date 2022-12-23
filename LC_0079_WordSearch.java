public class LC_0079_WordSearch {
    public boolean exist(char[][] board, String word) {
        
        int m = board.length;
        int n = board[0].length;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (this.recur(board, i, j, word, 0))
                    return true;
            }
        }

        return false;
    }

    private boolean recur(char[][] board, int i, int j, String word, int index) {

        if (!this.inBound(board, i, j))
            return false;

        char c = board[i][j];
        if (c != word.charAt(index))
            return false;
        
        if (index == word.length()-1)
            return true;

        board[i][j] = '#';
        
        if (recur(board, i, j+1, word, index+1))
            return true;
        
        if (recur(board, i, j-1, word, index+1))
            return true;

        if (recur(board, i+1, j, word, index+1))
            return true;

        if (recur(board, i-1, j, word, index+1))
            return true;
        
        board[i][j] = c;
        return false;
    }

    private boolean inBound(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        if (i >=0 && i<m && j>=0 && j<n)
            return true;
        else
            return false;
    }
}