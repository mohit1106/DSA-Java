// https://www.geeksforgeeks.org/dsa/connect-n-ropes-minimum-cost/
// given are N ropes of different lengths, task is to connect these ropes into one rope with minimum cost, such that the cost
// to connect two ropes is equal to sum of their lengths.
// approach - from PQ, get two smallest, find their sum/cost and add it to PQ, again get two smallest...
import java.util.*;

public class connectNropes {
    public static void main(String[] args) {
        int[] ropes = {2,3,3,4,6};

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }

        int cost = 0;
        while(pq.size() > 1) { // until therre is only one rope in PQ
            int min = pq.remove();
            int min2 = pq.remove();
            cost += min + min2;
            pq.add(min+min2);
        }
        System.out.println(cost);
    }
}
