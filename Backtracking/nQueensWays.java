// N-Queens - Place N queens on an NxN chessboard such that no 2 queens can attack each other
// Leetcode - https://leetcode.com/problems/n-queens/description/
// time - O(n!)

// count the total number of ways
public class nQueensWays {
    public static boolean isSafe(char[][] board, int row, int col){
        //verical up safe
        for (int i = row-1; i >= 0; i--) {
            if(board[i][col] == 'Q') return false;
        }

        // left diagnol up safe or not
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 'Q') return false;
        }

        // right diagnol up safe or not
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++){
            if(board[i][j] == 'Q') return false;
        }

        return true;
    }

    public static void queens(char[][] board, int row){
        if(row == board.length){
            count++;
            return;
        }

        for (int j = 0; j < board.length; j++) {
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                queens(board, row+1); // function call
                board[row][j] = 'x'; // bactracking step
            }
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

    static int count =0;

    public static void main(String[] args) {
        int n = 5;
        char board[][] = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'x';
            }
        }

        queens(board, 0);
        System.out.println(count);
    }
}