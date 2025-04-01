// quick sort
// avg. time O(nlog n)       worst time O(n^2)        space O(1)

public class pb2 {
    public static void printArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int[] arr, int startIdx, int endIdx){
        if(startIdx >= endIdx) return;
        int pivotIdx = partition(arr, startIdx, endIdx);
        quickSort(arr, startIdx, pivotIdx - 1);
        quickSort(arr, pivotIdx + 1, endIdx);
    }

    public static int partition(int[] arr, int startIdx, int endIdx){
        int pivot = arr[endIdx];
        int i = startIdx - 1; 
        for (int j = startIdx; j < endIdx; j++) {
            if(arr[j] <= pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot ;
        arr[endIdx] = arr[i];
        arr[i] = temp;
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 9, 8, 2, 5, -5};
        quickSort(arr, 0, arr.length-1);
        printArr(arr);
    }
}
