public class counting {
    public static void countingSort(int arr[]) {
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }
        int count[] = new int[largest + 1];
        for(int i=0; i<arr.length; i++) {
            count[arr[i]]++;
        }
        
        int j =0;
        for(int i=0; i<count.length; i++) {
            while(count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
        
    }
    public static void main(String[] args) {
        int[] arr = {1,5,7,5,1,3,6,4};
        countingSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
