import java.util.*;

public class adjacencyListGraph {
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {
        /*
            graph  vertexValue -> {src, dest, wt}
            0 -> {0,1,5} 
            1 -> {1,0,5}, {1,2,1}, {1,3,3}
            2 -> {2,1,1}, {2,3,1}, {2,4,2}
            3 -> {3,1,3}, {3,2,1}
            4 -> {4,2,2}
        */

        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // for vertex 0
        graph[0].add(new Edge(0, 1, 5));
        // for vertex 1
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));
        // for vertex 2
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));
        // for vertex 3
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));
        // for vertex 4
        graph[4].add(new Edge(4, 2, 2));


        // for vertex 2, find all its neighbors - O(k), K = size of the list of graph[2]
        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.println(e.dest);
        }
    }
}
