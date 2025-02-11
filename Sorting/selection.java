public class selection {
    public static void selectionSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i <= n-2; i++) {
            int minPos = i;
            for (int j = i+1; j <= n-1; j++) {
                if(arr[minPos] > arr[j]){
                    minPos = j;
                }
            }
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String[] args) {
        int arr[] = {5,4,1,3,2};
        selectionSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
