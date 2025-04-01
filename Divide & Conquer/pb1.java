// merge sort  - implemented by depth first approach
// time - O(n log n)
// space - O(n)

public class pb1 {
    public static void printArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void mergeSort(int[] arr, int startIdx, int endIdx){
        if(startIdx >= endIdx) return;                                 // base case
        
        int mid = startIdx + (endIdx - startIdx)/2;                    // (startIdx + endIdx)/2 also works
        mergeSort(arr, startIdx, mid);                                 // left part
        mergeSort(arr, mid + 1, endIdx);                               // right part
        merge(arr, startIdx, mid, endIdx);
    }

    public static void merge(int[] arr, int startIdx, int mid, int endIdx){
        int[] temp = new int[endIdx - startIdx + 1];
        int i = startIdx; // iterator for left part
        int j = mid + 1;  // iterator for right part
        int k = 0;        // iterator for temp

        while(i<=mid && j<=endIdx){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            } else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while(i<=mid) temp[k++] = arr[i++]; // for remaining left part
        while(j<=endIdx) temp[k++] = arr[j++]; // for remaining right part

        for(k=0, i = startIdx; k<temp.length; k++, i++) arr[i] = temp[k]; // copying temp to original array
    }
    public static void main(String[] args) {
        int[] arr = {6, 3, 9, 5, 2, 8, -2};
        mergeSort(arr, 0, arr.length - 1);
        printArr(arr);
    }
}
