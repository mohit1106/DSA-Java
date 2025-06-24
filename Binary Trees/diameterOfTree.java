// find the diameter of a binary tree - O(n^2)

public class diameterOfTree {
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
    public static int findHeight(Node root){
        if(root == null) return 0;

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int diameter(Node root){
        if(root == null){
            return 0;
        }
        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        int diameterThroughtRoot = leftHeight + rightHeight + 1;
        return Math.max(diameterThroughtRoot, Math.max(leftDiameter, rightDiameter));
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(diameter(root));
    }
}