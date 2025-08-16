/*
visited[]: Tracks all nodes that have been visited.
recStack[] (recursion stack): Tracks visited nodes in the current DFS path i.e in current recursion stack

DFS logic:
Start DFS from each unvisited node.
Mark the current node as visited and add it to the recursion stack.
For each neighbor:
    If the neighbor is not visited, recursively DFS on it.
    If the neighbor is in the recursion stack, a cycle is detected. (because we came to curr node through that neighbor path)
Remove the node from recursion stack before returning.
*/

import java.util.ArrayList;

public class cycleInDirected {
    static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2 ));

        graph[1].add(new Edge(1, 0 ));

        graph[2].add(new Edge(2, 3 ));

        graph[3].add(new Edge(3, 0 ));

    }
    
    public static boolean isCycle(ArrayList<Edge>[] graph){
        boolean[] visited = new boolean[graph.length];
        boolean[] stackVisited = new boolean[graph.length];
 
        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                if(isCycleUtil(graph, i, visited, stackVisited)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean[] visited, boolean[] stackVisited){
        visited[curr] = true;
        stackVisited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(stackVisited[e.dest]){
                return true;
            }
            if(!visited[e.dest] && isCycleUtil(graph, e.dest, visited, stackVisited)){ 
                return true;
            }
        }
        stackVisited[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        System.out.println(isCycle(graph));
    }
}