// https://www.geeksforgeeks.org/dsa/bottom-view-binary-tree/
import java.util.*;

public class bottomViewBinaryTree {
    static class Node{
        int data;
        Node left, right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Info{
        Node node;
        int hd;

        public Info(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }

    public static ArrayList<Integer> bottomView(Node root){
        if(root == null){
            return new ArrayList<>();
        }
        TreeMap<Integer, Integer> hdmap = new TreeMap<>();
        Queue<Info> q = new LinkedList<>();

        q.add(new Info(root, 0));
        while(!q.isEmpty()){
            Node curr = q.peek().node;
            int hd = q.peek().hd;
            q.poll();

            hdmap.put(hd, curr.data);

            if(curr.left != null){
                q.add(new Info(curr.left, hd-1));
            }
            if(curr.right != null){
                q.add(new Info(curr.right, hd+1));
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int val : hdmap.values()){
            res.add(val);
        }
        return res;
    }

    public static void main(String[] args) {
        // Representation of the input tree:
        //       20
        //      /  \
        //     8   22
        //    / \    \
        //   5   3   25
        //      / \
        //     10 14
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right.right = new Node(25);

        ArrayList<Integer> res = new ArrayList<>();
        res = bottomView(root);

        for (int val : res) {
          System.out.print(val + " ");
        }
    }
}
