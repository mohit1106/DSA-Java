public class printSpiral {
    public static void spiral(int[][] arr){
        int startRow = 0;
        int startCol = 0;
        int endRow = arr.length - 1;
        int endCol = arr[0].length -1;

        while (startRow <= endRow && startCol <= endCol){
            for (int i = startRow; i <= endRow; i++){
                System.out.print(arr[startRow][i] + " ");
            }
            for (int i = startRow + 1; i <= endRow; i++){
                System.out.print(arr[i][endCol] + " ");
            }
            for (int i = endCol - 1; i >= startCol; i--){
                if (startRow == endRow) {
                    break;
                }
                System.out.print(arr[endRow][i] + " ");
            }
            for (int i = endRow - 1; i >= startRow + 1; i--){
                if (startCol == endCol) {
                    break;
                }
                System.out.print(arr[i][startCol] + " ");
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
            // System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 10}, 
                       {4, 5, 6, 45}, 
                       {7, 8, 9, 25},
                       {5, 6, 4, 56}};
        spiral(arr);
    }
}
