// N-Queens - Place N queens on an NxN chessboard such that no 2 queens can attack each other
// Leetcode - https://leetcode.com/problems/n-queens/description/


// version
// ways to place n queens into n rows in a nXn board
public class nQueens {
    public static void queens(char[][] board, int row){
        if(row == board.length){
            printBoard(board);
            return;
        }

        for (int j = 0; j < board.length; j++) {
            board[row][j] = 'Q';
            queens(board, row+1); // function call
            board[row][j] = 'x'; // bactracking step
        }
    }

    public static void printBoard(char[][] board){
        System.out.println("---------------------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 2;
        char board[][] = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'x';
            }
        }

        queens(board, 0);
    }
}