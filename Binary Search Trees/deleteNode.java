// deleting a node from BST and then maintaining the BST also

public class deleteNode {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
        }
    }

    public static Node delete(Node root, int val){
        if(root.data > val){
            root.left = delete(root.left, val);
        } else if(root.data < val){
            root.right = delete(root.right, val);
        } else{ // root.data == val i.e found the correct node
            if (root.left == null && root.right == null) { // deleting the leaf node
                return null;
            }

            if(root.left == null){           // deleting nodes with only one child
                return root.right;
            } else if(root.right == null){
                return root.left;
            }

            Node IS = findInorderSuccessor(root.right);  // for node with two child
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static Node findInorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
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
    public static void inorder(Node root){
        if(root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int values[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;
        for(int a : values){
            root = insert(root, a);
        }

        inorder(root);
        System.out.println();

        delete(root, 5);
        inorder(root);

    }
}
