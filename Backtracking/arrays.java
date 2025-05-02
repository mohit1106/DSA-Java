import java.util.*;

public class arrays {
    public static void changeArr(int[] arr, int i, int value){
        if (i == arr.length) {
            return;
        }

        arr[i] = value;
        changeArr(arr, i+1, value+1);
        arr[i] = arr[i] - 2; // backtracking step
    }
    public static void main(String[] args) {
        int[] arr = new int[5];
        changeArr(arr, 0, 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
