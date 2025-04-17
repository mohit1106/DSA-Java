// print x to the power of n

public class pb8 {
    // normal approach - O(n) complexity
    public static int power(int x, int n){
        if (n == 0) {
            return 1;
        }
        return x * power(x, n-1);
    }

    // optimized approach - O(log n) time and space complexity
    public static int powerOf(int x, int n){
        if (n == 0) return 1;
        int halfPower = powerOf(x, n/2);

        if(n%2 != 0){
            return x * halfPower * halfPower;
        }
        return halfPower * halfPower;
    }

    public static void main(String[] args) {
        System.out.println(power(2, 10));
        System.out.println(powerOf(2, 10));
    }
}