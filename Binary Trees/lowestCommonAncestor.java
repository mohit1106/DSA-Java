// ancestor - all the nodes from root to the given node are ancestor for that node in path from root to node
        /*
                         1
                       /  \
                      2    3
                     / \  / \
                    4   5 6  7
        */ 
        // for 5, 2 and 1 are its ancestors
        // for 5 and 6, 1 is their lowest common ancestors
        // for 4 and 5, 2 is their lowest common ancestor
// given two nodes, find their lowest/first common ancestor - O(n)

import java.util.*;

public class lowestCommonAncestor {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path){
        if(root==null) return false;

        path.add(root);
        if(root.data==n){
            return true;
        }
        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if (foundLeft || foundRight) {
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }

    public static Node lca(Node root, int n1, int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i=0;
        for(; i<path1.size() && i<path2.size(); i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }
        Node lca = path1.get(i-1);
        return lca;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n1=4, n2=7;
        System.out.println(lca(root, n1, n2).data);
    }
}
