public class binarySearch {
    public static int binary(int arr[], int key) {
        int start=0, end = arr.length-1;
        while (start<=end) {
            int mid = (start + end) / 2;
            if (arr[mid]==key) {
                return mid;
            }
            else if(arr[mid] > key){
                end = mid-1;
            }         
            else {
                start = mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int numbers[] = {78, 45, 5, 56, 12};
        System.out.println(binary(numbers, 25));
    }
}


// time complexity = O(log n)