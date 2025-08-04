// https://leetcode.com/problems/sliding-window-maximum/description/
// approach - in Priority queue, add the k elements, this PQ will be of max Heap i.e max element have max priority.
//            now, the front of PQ will have max element in that k sized window, so store it in result array
//            for next window, see if the max element in PQ(from previous window) have idx outside current window
//            remove elements from PQ while pq.peek().idx <= (i-k) after that add the current element     
//            here, i is the idx of the currnet element or the last element in the current window.
///////////// size of result array = n-k+1
import java.util.*;
public class slidingWindowMax {
    static class Pair implements Comparable<Pair> {
        int val;
        int idx;
        public Pair (int val, int idx){
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p2){
            // return this.val - p2.val;   this is to sort in ascending
            return p2.val - this.val;  // for descending
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k=3;
        int res[] = new int[arr.length - k + 1];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {     // store the elements of 1st wondow in pq manually
            pq.add(new Pair(arr[i], i));
        }
        res[0] = pq.peek().val;

        for(int i=k; i<arr.length; i++){
            while (pq.size() > 0 && pq.peek().idx <= (i-k)) {
                pq.remove();
            }

            pq.add(new Pair(arr[i], i));
            res[i-k+1] = pq.peek().val;
        }

        for (int a : res) {
            System.out.print(a+" ");
        }
    }
}