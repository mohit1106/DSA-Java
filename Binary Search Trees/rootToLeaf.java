// print all the paths from root to the every leaf

import java.util.*;
public class rootToLeaf {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
        }
    }
    public static void printPath(ArrayList<Integer> path){
        for(int i=0; i<path.size(); i++){
            System.out.print(path.get(i) + " ");
        }
        System.out.println("null");
    }
    public static void printAllPaths(Node root, ArrayList<Integer> path){
        if (root==null) {
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            printPath(path);
        }
        printAllPaths(root.left, path);
        printAllPaths(root.right, path);

        path.remove(path.size()-1);
    }


    // non core
    public static Node insert(Node root, int val){
        if(root==null){
            root = new Node(val);
            return root;
        }
        if(root.data > val){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }
    public static void main(String[] args) {
        int values[] = {8,5,3,6,10,11,14};
        Node root = null;
        for(int a : values){
            root = insert(root, a);
        }
        ArrayList<Integer> path = new ArrayList<>();
        printAllPaths(root, path);
    }
}
