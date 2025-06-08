/*
Next Greater Element - the next greater element of some element x in an array is the first greater
element that is to the right of x in the same array.

time - O(n)
*/
import java.util.*;
public class nextGreater {


    public static void main(String[] args) {
        int[] arr = {6,8,0,1,3};
        Stack<Integer> s = new Stack<>();  // stack will have index of the elements not the value

        int[] nextBig = new int[arr.length];
        for(int i=arr.length - 1; i>=0; i--){ // iterating from right side so that when we reach an element we already have analysed all elemets that are right to it
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                s.pop();
            }
            if(s.isEmpty()) nextBig[i] = -1;
            else nextBig[i] = arr[s.peek()];

            s.push(i);
        }


        for (int i = 0; i < nextBig.length; i++) {
            System.out.println(nextBig[i]);
        }
    }
}