// search for a given key a binary search tree - O(H)
public class searchKey {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
        }
    }

    public static boolean search(Node root, int key){
        if(root == null) return false;

        if(root.data == key) return true;
        
        if(root.data > key){
            return search(root.left, key);
        } else{
            return search(root.right, key);
        }
    }

    // for buildoiing the BST, not core part for this problem
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
        int values[] = {5,1,3,4,2,7};
        Node root = null;
        for(int a : values){
            root = insert(root, a);
        }

        System.out.println(search(root, 6));
    }
}
