// print numbers from n to 1

public class pb1 {
    public static void printNumbers(int n){
        if (n>=1){
            System.out.println(n);
            printNumbers(n-1);
        }
    }
    public static void main(String[] args) {
        printNumbers(10);
    }
}
