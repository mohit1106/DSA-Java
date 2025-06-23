/*
given two arrays A and B of equal length n. pair each ellemnt of array A to an element
in Array B, such that sum of absolute differences of all the pairs is minimum.

A = {1, 2, 3}
B = {2, 1, 3}
ans = 0
*/

import java.util.Arrays;

public class minAbsoluteDifference {

    public static void main(String[] args) {
        int[] arr1 = {4, 1, 8, 7};
        int[] arr2 = {2, 3, 6, 5};

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int res = 0;
        for (int i = 0; i < arr1.length; i++) {
            res += Math.abs(arr1[i] - arr2[i]);
        }
        System.out.println(res);
    }
}