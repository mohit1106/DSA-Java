// https://leetcode.com/problems/largest-rectangle-in-histogram/description/
// time - O(n)

import java.util.*;
public class maxArea {

    public static void findMax(int[] arr){
        int max = 0;
        int nsr[] = new int[arr.length]; // next smaller in right - stores their index  - if not exist then n
        int nsl[] = new int[arr.length]; // next smaller in left - stores their index  - if not exist then -1

        Stack<Integer> s = new Stack<>();
        for(int i=arr.length - 1; i>=0; i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()) nsr[i] = arr.length;
            else nsr[i] = s.peek(); 
            s.push(i);
        }

        s = new Stack<>();
        for(int i=0; i<arr.length; i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }
            if(s.isEmpty()) nsl[i] = -1;
            else nsl[i] = s.peek(); 
            s.push(i);
        }

        for (int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            max = Math.max(max, currArea);
        }
        System.out.println(max);
    }
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3};
        findMax(arr);
    }
}