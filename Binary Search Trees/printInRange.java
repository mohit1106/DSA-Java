// given two numbers(ranges), print all the numbers in between them that exist in BST

public class printInRange {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
        }
    }

    public static void printAll(Node root, int k1, int k2){
        if(root==null){
            return;
        }
        if(root.data >= k1 && root.data <= k2){
            printAll(root.left, k1, k2);
            System.out.print(root.data + " ");
            printAll(root.right, k1, k2);
        } else if(root.data < k1){
            printAll(root.left, k1, k2);
        } else if(root.data > k2){
            printAll(root.right, k1, k2);
        }
    }
    public static void main(String[] args) {
        
    }
}
