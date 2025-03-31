/*
Binary Strings Problem: Print all binary strings of size N without consecutive ones.
*/
public class pb12 {
    public static void binaryString(int n, int prev, String str){
        if(n==0){
            System.out.println(str);
            return;
        }

        binaryString(n-1, 0, str+"0");
        if(prev == 0) {   
            binaryString(n-1, 1, str+"1");
        }
    }
    public static void main(String[] args) {
        binaryString(3, 0, "");
    }
}