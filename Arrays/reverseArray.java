public class reverseArray {
    public static void reverse(int[] arr){
        for (int i = 0; i <= arr.length/2; i++) {
            int temp= arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }
    }
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5};
        reverse(numbers);
        for (int i : numbers) {
            System.out.print(i);
        }
    }
}
// time complexity = O(n)