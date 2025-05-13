// write a fxn to complete a sudoku of 9X9 grid

public class sudoku {

    public static boolean isSafe(int board[][], int row, int col, int digit){
        //column
        for(int i=0; i<9; i++){
            if(board[i][col] == digit) return false;
        }
        //row
        for(int j=0; j<9; j++){
            if(board[row][j] == digit) return false;
        }
        //grid check
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for(int i=startRow; i<startRow+3; i++){
            for(int j=startCol; j<startCol+3; j++){
                if(board[i][j] == digit) return false;
            }
        }
        return true;
    }
    
    public static boolean solve(int board[][], int row, int col){
        //base
        if(row==9 && col==0) return true;
        // else if(row==9) return false;

        //rec
        int nextRow = row, nextCol = col+1;
        if(col+1 == 9){
            nextRow = row+1;
            nextCol = 0;
        }
        if (board[row][col] != 0) {
            return solve(board, nextRow, nextCol);
        }
        for(int digit=1; digit<=9; digit++){
            if (isSafe(board, row, col, digit)) {
                board[row][col] = digit;
                if(solve(board, nextRow, nextCol)){
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] board = {
                        {5, 3, 0, 0, 7, 0, 0, 0, 0},
                        {6, 0, 0, 1, 9, 5, 0, 0, 0},
                        {0, 9, 8, 0, 0, 0, 0, 6, 0},
                        {8, 0, 0, 0, 6, 0, 0, 0, 3},
                        {4, 0, 0, 8, 0, 3, 0, 0, 1},
                        {7, 0, 0, 0, 2, 0, 0, 0, 6},
                        {0, 6, 0, 0, 0, 0, 2, 8, 0},
                        {0, 0, 0, 4, 1, 9, 0, 0, 5},
                        {0, 0, 0, 0, 8, 0, 0, 7, 9}
                        };
        if(solve(board, 0, 0)){
            System.out.println("solution exists");
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("doesnt exist");
        }
    }
}