// Find a number of ways to reach from (0, 0) to (n-1, m-1) in a nxm grid.
//allowed moves - right or down

// time - O(2^(n+m))
public class gridWays {
    public static int ways(int i, int j, int n, int m){
        if (i == n-1 && j == m-1) {
            return 1;
        } else if (i==n || j==m) {
            return 0;
        }
        return ways(i, j+1, n, m) + ways(i+1, j, n, m);
    }

    public static void main(String[] args) {
        int n=3, m=3;
        int res = ways(0, 0, n, m);
        System.out.println(res);
    }
}

// another approach - O(n) time
// ways = ((n-1 + m-1)!) / ((n-1)! * (m-1)!)