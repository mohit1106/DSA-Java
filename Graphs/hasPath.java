// for given source and destination, tell if a path exists from src to dest
// approach - use dfs, start from src, and search for dest through neighbors and stop when dest found.
// i.e recursively, if from a neighbor to dest, path exists, then from you(src) to dest also exists, because there is always path b/w src and its neighbor.
// so, src pointer will keep moving deeper to its neighbors and at one point it'll reach dest itself, return true when src == dest
// time - O(V + E)

import java.util.*;

public class hasPath {
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

    static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));

    }
    
    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] visited){
        
        System.out.print(curr + " ");
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                dfs(graph, e.dest, visited);
            }
        }
    }
    
    public static boolean existsPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited){
        if(src == dest) {
            return true;
        }

        visited[src] = true;
        for(int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            // e.dest = neighbor
            if(!visited[e.dest] && existsPath(graph, e.dest, dest, visited)){
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        boolean doesitexist = existsPath(graph, 0, 5, new boolean[V]);
        System.out.println(doesitexist);
    }
}
