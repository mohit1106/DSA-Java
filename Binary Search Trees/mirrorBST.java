// mirror a BST - i.e for each node its left subtree will become right subtree and vice versa
// O(n)
public class mirrorBST {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
        }
    }

    public static Node mirror(Node root){
        if (root == null) {
            return null;
        }
        Node leftMirror = mirror(root.left);
        Node rightMirror = mirror(root.right);

        root.left = rightMirror;
        root.right = leftMirror;
        return root;
    }

    public static void preorder(Node root){
        if(root == null) return;

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        /*
             8                                      8
           /  \                                   /  \
          5    10           ->                   10   5
         / \    \                               /    / \
        3   6    11                            11    6  3
    */
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);

        preorder(root);
        System.out.println();
        root = mirror(root);
        preorder(root);
    }
}
