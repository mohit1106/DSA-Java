// write a program to find the last occurence of a number in an array

public class pb7 {

    // method 1 - backward approach
    public static int findLastOccurrence(int[] arr, int key, int i){
        if(i < 0 ) return -1;
        if(arr[i] == key) return i;
        return findLastOccurrence(arr, key, i-1);
    }


    // method 2 - forward approach
    public static int lastOccurrence(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }
        int isFound = lastOccurrence(arr, key, i + 1);
        if (isFound == -1 && arr[i] == key) {
            return i;
        }
        return isFound;
    }


    public static void main(String[] args) {
        int[] arr = {1, 8, 3, 4, 4, 5, 5, 5, 6, 7, 8, 8, 9};
        System.out.println(findLastOccurrence(arr, 8, arr.length - 1));
        System.out.println(lastOccurrence(arr, 8, 0));
    }
}
