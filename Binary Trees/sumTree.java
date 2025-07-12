// transform to sum tree
// node in a subtree is sum of its all left and right subtree, ex. for leafs, it'll be 0
/*
             1                                     27
           /  \                                   /  \
          2    3                                 9    13
         / \  / \                               / \   / \
        4   5 6  7                             0   0 0   0
*/
public class sumTree {
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

    public static int makeSum(Node root){
        if(root==null) return 0;

        int leftchild = makeSum(root.left);
        int rightchild = makeSum(root.right);

        int data = root.data;

        int newLeftData = root.left == null ? 0 : root.left.data;  // left node's new value
        int newRightData = root.right == null ? 0 : root.right.data;
        int orgLeftData = leftchild; // left node's original data
        int orgRightData = rightchild;
        root.data = newLeftData + orgLeftData + newRightData + orgRightData;

        return data;

    }

    public static void preorder(Node root){
        if(root == null) return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        makeSum(root);
        preorder(root);
    }
}
