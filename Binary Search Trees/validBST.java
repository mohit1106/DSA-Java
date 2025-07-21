// check if a given BST is valid BST and following all the properties of BST
// approach 1 - check if its inorder is sorted
// aproach 2 - left subtree nodes can lie in Integer.MIN_VALUE to root.data-1  and
//             right subtree nodes can lie in root.data+1 to Integer.MAX_VALUE

public class validBST {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
        }
    }

    public static boolean isValid(Node root, Node min, Node max){
        if(root==null){
            return true;
        }
        if(min!=null && root.data <= min.data){
            return false;
        } else if(max!=null && root.data >= max.data){
            return false;
        }
        return isValid(root.left, min, root) && isValid(root.right, root, max);
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
        System.out.println(isValid(root, null, null));
    }
}
