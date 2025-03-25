// write a program to find the first occurence of a number in an array

public class pb6 {
    public static int findFirstOccurrence(int[] arr, int key, int i){
        if(i == arr.length) return -1;
        if(arr[i] == key) return i;
        return findFirstOccurrence(arr, key, i+1);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 5, 6, 7, 8, 9};
        System.out.println(findFirstOccurrence(arr, 8, 0));
    }
}
