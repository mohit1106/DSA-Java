// https://leetcode.com/problems/k-closest-points-to-origin/description/

// we are given N points in a 2D plane which are locations of N cars. if we are at the origin, print nearset K cars.
// approach - simply find (distance)^2 of all the points from (0, 0), add all cars in priority queue with their dist.
//            then priority queue will automatically sort them in increasing order, because lowest dist value will have highest priority.
//            make distance^2 as the factor of comparison i.e on this basis PQ will sort

import java.util.*;

public class nearbyCars {
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int distSq;
        int idx;
        public Point(int x, int y, int distSq, int idx){
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2){
            return this.distSq - p2.distSq;  // sort in ascending order on basis of distSq
        }
    }

    public static void main(String[] args) {
        int[][] pts = {{3,3}, {5,-1}, {-2,4}};
        int k=2;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int i = 0; i < pts.length; i++) {
            int distSq = pts[i][0]*pts[i][0] + pts[i][1]*pts[i][1];
            pq.add(new Point(pts[i][0], pts[i][1], distSq, i));
        }

        for (int i = 0; i < k; i++) {
            System.out.println("car" + pq.remove().idx);
        }
    }
}