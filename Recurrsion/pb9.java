/* 
problem: Given a “2 x n” board and tiles of size “2 x 1”, count the number of ways to tile the given board using the 2 x 1 tiles.
(A tile can either be placed horizontally or vertically.)
*/


public class pb9 {
    public static int tilingWays(int n){
        if(n==0 || n==1) return 1;

        // vertical ways = tilingWays(n-1) & horizontal ways = tilingWays(n-2)
        return tilingWays(n-1) + tilingWays(n-2);
    }
    public static void main(String[] args) {
        System.out.println(tilingWays(4));
    }
}