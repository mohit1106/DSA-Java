/*
Search in Rotated Sorted Array
Input: sorted, rotated array with distinct numbers (in ascending order).
It is rotated at a pivot point. Find the index of given element.
*/

public class pb3 {
    public static int search(int[] arr, int target) {
        return recursiveSearch(arr, target, 0, arr.length - 1);
    }
    
    private static int recursiveSearch(int[] arr, int target, int startIdx, int endIdx) {
        // Base case: element not found
        if (startIdx > endIdx) {
            return -1;
        }
        
        int mid = startIdx + (endIdx - startIdx) / 2;
        
        // Base case: element found
        if (arr[mid] == target) {
            return mid;
        }
        
        // Left half is sorted
        if (arr[startIdx] <= arr[mid]) {
            if (arr[startIdx] <= target && target < arr[mid]) {
                return recursiveSearch(arr, target, startIdx, mid - 1);
            } else {
                return recursiveSearch(arr, target, mid + 1, endIdx);
            }
        } 
        // Right half is sorted
        else {
            if (arr[mid] < target && target <= arr[endIdx]) {
                return recursiveSearch(arr, target, mid + 1, endIdx);
            } else {
                return recursiveSearch(arr, target, startIdx, mid - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(search(arr, target));  // Output: 4
    }
}
