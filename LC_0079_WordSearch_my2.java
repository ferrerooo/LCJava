public class LC_0079_WordSearch_my2 {
    public boolean exist(char[][] board, String word) {
        
        int m = board.length;
        int n = board[0].length;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {

                if (dfs(board, i, j, word, 0))
                    return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) 
            return true;
        
        if (board[i][j] != word.charAt(index))
            return false;
        
        if (board[i][j] == word.charAt(index) && index == word.length()-1)
            return true;

        board[i][j] = '.';

        if (isValid(board, i+1, j) && dfs(board, i+1, j, word, index+1))
            return true;
        
        if (isValid(board, i-1, j) && dfs(board, i-1, j, word, index+1))
            return true;
        
        if (isValid(board, i, j+1) && dfs(board, i, j+1, word, index+1))
            return true;

        if (isValid(board, i, j-1) && dfs(board, i, j-1, word, index+1))
            return true;
        
        board[i][j] = word.charAt(index);

        return false;
    }

    private boolean isValid(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;

        if (i >=0 && i<m && j>=0 && j < n)
            return true;
        else
            return false;
    }
}