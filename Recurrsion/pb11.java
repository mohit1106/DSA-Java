/*
Friends Pairing Problem: Given n friends, each one can remain single or can be paired up with some other friend. 
Each friend can be paired only once. Find out the total number of ways in which friends can remain single or can be paired up.
*/

public class pb11 {
    public static int countWays(int n){
        if(n==1 || n==2) return n;

        //single - countWays(n-1) & pair - (n-1) * countWays(n-2)
        return countWays(n-1) + (n-1) * countWays(n-2);
    }
    public static void main(String[] args) {
        System.out.println(countWays(3));
    }
}