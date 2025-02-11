// Brute force approach
// time complexity = O(n^3)

// import java.util.*;
// public class maxSubarraySum {
//     public static int sub(int[] arr){
//         int max = Integer.MIN_VALUE;
//         int curr = 0;
//         for (int i = 0; i < arr.length; i++) {
//             for (int j = 0; j < arr.length; j++) {
//                 curr = 0;
//                 for (int k = i; k <= j; k++) {
//                     curr = curr+arr[k];
//                 }
//                 if (curr>max) {
//                     max = curr;
//                 }
//             }
//         }
//         return max;
//     }
//     public static void main(String[] args) {
//         int[] arr = {1,-2,6,-1,3};
//         System.out.println(sub(arr));
//     }
// }








// prefix sum approach
// time complexity = O(n^2)

// import java.util.*;
// public class maxSubarraySum {
//     public static int sub(int[] arr){
//         int maxSum = Integer.MIN_VALUE;
//         int currSum = 0;

//         int[] prefixArray = new int[arr.length];
//         prefixArray[0] = arr[0];
//         for (int i = 1; i < prefixArray.length; i++) {
//             prefixArray[i] = prefixArray[i-1] + arr[i];
//         }

//         for (int i = 0; i < arr.length; i++) {
//             for (int j = 0; j < arr.length; j++) {
//                 currSum = i==0 ? prefixArray[j] : prefixArray[j] - prefixArray[i-1];
//                 if (maxSum<currSum) {
//                     maxSum = currSum; 
//                 }
//             }
//         }
//         return maxSum;
//     }
//     public static void main(String[] args) {
//         int[] arr = {1,-2,6,-1,4};
//         System.out.println(sub(arr));
//     }
// }






// kadane's algorithm approach - whenever currentSum becomes -ve, make it 0 instead.
// best solution - O(n)
// it doesn't cover the case when all elements are -ve, it will give 0 as max

import java.util.*;
public class maxSubarraySum {
    public static int sub(int arr[]){
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currSum = currSum + arr[i];
            if (currSum < 0) {
                currSum = 0;
            }
            if (maxSum<currSum) {
                maxSum = currSum;
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] arr = {-2,-3,4,-1,-2,1,5,-3};
            System.out.println(sub(arr));
    }
}