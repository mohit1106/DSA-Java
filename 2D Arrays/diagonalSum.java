public class diagonalSum {



    ///////////////////////////////// bruteforce //////////////////////////////////////////////////////////////////
    // public static int diagSum(int[][] matrix){
    //     int sum =0;
        
    //     for (int i = 0; i < matrix.length; i++) {
    //         for (int j = 0; j < matrix[0].length; j++) {
    //             // sum of primary diagonal elements
    //             if (i == j){
    //                 sum += matrix[i][j];
    //             }
    //             // sum of secondary diagonal elements
    //             else if (i+j == matrix.length-1) {
    //                 sum += matrix[i][j];
    //             }
    //         }
    //     }
    //     return sum;
    // }

    ///////////////////////////////// optimized approach using one pass and constant space //////////////////////
    public static int diagSum(int[][] matrix){
        int sum =0;
        
        for (int i = 0; i < matrix.length; i++) {
            // primary diagonal elements sum
            sum += matrix[i][i];

            // secondary diagonal elements sum
            if(i != matrix.length-i-1)
                sum += matrix[i][matrix.length-i-1];  // i+j = n-1,   where n = matrix.length
                
        }
        return sum;
    }




    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 0}, 
                       {4, 5, 6, 5}, 
                       {7, 8, 9, 5},
                       {5, 6, 4, 6}};
        System.out.println(diagSum(arr));
    }
}
