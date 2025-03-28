// write a program to find the first occurence or last Occurence of a number in an array

public class pb6 {
    public static int findFirstOccurrence(int[] arr, int key, int i){
        if(i == arr.length) return -1;
        if(arr[i] == key) return i;
        return findFirstOccurrence(arr, key, i+1);
    }
    public static int findLastOccurrence(int[] arr, int key, int i){
        if(i < 0 ) return -1;
        if(arr[i] == key) return i;
        return findLastOccurrence(arr, key, i-1);
    }
    public static void main(String[] args) {
        int[] arr = {1, 8, 3, 4, 4, 5, 5, 5, 6, 7, 8, 8, 9};
        System.out.println(findFirstOccurrence(arr, 5, 0));
        System.out.println(findLastOccurrence(arr, 5, arr.length - 1));
    }
}
