class Solution {
    public void solveSudoku(char[][] board) {
        solveSudoku(board, 0, 0);
    }

    public boolean solveSudoku(char[][] board, int x, int y) {
        if(y == 9) return true;
        if(x == 9) return solveSudoku(board, 0, y + 1);

        if(board[x][y] == '.'){
            for(int i = 0; i < 9; i++){
                if(isValidChar(board, x, y, (char)('1' + i))){
                    board[x][y] = (char)('1' + i);
                    if(solveSudoku(board, x + 1, y)){
                        return true;
                    }
                    board[x][y] = '.';
                }
            }
            return false;
        }
        return solveSudoku(board, x + 1, y);
    }

    public boolean isValidChar(char[][] board, int x, int y, char temp){
        for(int i = 0; i < 9; i++){
            if(i != x && board[i][y] == temp) {
                return false;
            }
        }

        for(int i = 0; i < 9; i++){
            if(i != y && board[x][i] == temp) {
                return false;
            }
        }

        int a = x / 3, b = y / 3;

        for(int i = 3 * a; i < 3 * a + 3; i++){
            for(int j = 3 * b; j < 3 * b + 3; j++){
                if(i != x && j != y && board[i][j] == temp){
                    return false;
                }
            }
        }

        return true;
    }
}