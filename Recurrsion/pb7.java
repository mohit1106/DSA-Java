// write a program to find the first occurence of a number in an array

public class pb7 {
    public static int findLastOccurrence(int[] arr, int key, int i){
        if(i < 0 ) return -1;
        if(arr[i] == key) return i;
        return findLastOccurrence(arr, key, i-1);
    }
    public static void main(String[] args) {
        int[] arr = {1, 8, 3, 4, 4, 5, 5, 5, 6, 7, 8, 8, 9};
        System.out.println(findLastOccurrence(arr, 5, arr.length - 1));
    }
}
