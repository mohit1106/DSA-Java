// https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix
// approach - in PQ, sort on the basis of no. of soldiers and if same then idx is less

import java.util.PriorityQueue;

public class weakestSoldier {
    static class Row implements Comparable<Row> {
        int soldiers;
        int idx;
        public Row(int soldiers, int idx){
            this.soldiers = soldiers;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row r2){
            if (this.soldiers == r2.soldiers) { // if same soldires then sort on basis of idx
                return this.idx - r2.idx;
            } else{
                return this.soldiers - r2.soldiers; // sort on basis of no. of soldiers
            }
        }
    }
    public static void main(String[] args) {
        int[][] army = {{1,0,0,0},
                        {1,1,1,1},
                        {1,0,0,0},
                        {1,0,0,0}};
        int k = 2;

        PriorityQueue<Row> pq = new PriorityQueue<>();
        for (int i = 0; i < army.length; i++) { // iterate over each row

            int count = 0;
            for (int j = 0; j < army[0].length; j++) { // iterate in one row and count no. of soldiers in it
                count += army[i][j] == 1 ? 1 : 0;
            }

            pq.add(new Row(count, i));
        }

        for (int i = 0; i < k; i++) {
            System.out.println("Row " + pq.remove().idx);
        }
    }
}
