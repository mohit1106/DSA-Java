/*
topological sort - works on directed acyclic graph (DAG) i.e on directed graphs with no cycles.
topological sorting is used only for DAGs(not for non-DAGs).
it is a linear order of vertices such that every directed edge u --> v, the vertex u comes before v in the order.
its like the node on which another node is depending should come first i.e like dependency in which least dependent task comes first and then the ones which depend on others.

time - O(V+E)
*/

import java.util.ArrayList;
import java.util.Stack;

public class topologicalSort {
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

        graph[2].add(new Edge(2, 3 ));

        graph[3].add(new Edge(3, 1 ));

        graph[4].add(new Edge(4, 0 ));
        graph[4].add(new Edge(4, 1 ));

        graph[5].add(new Edge(5, 0 ));
        graph[5].add(new Edge(5, 2 ));

    }
    
    public static void topSort(ArrayList<Edge>[] graph){
        boolean[] visited = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();
 
        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                topSortUtil(graph, i, visited, stack);
            }
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
    
    public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] visited, Stack<Integer> stack){
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){ 
                topSortUtil(graph, e.dest, visited, stack);
            }
        }
        stack.push(curr);
    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        topSort(graph);
    }
}
