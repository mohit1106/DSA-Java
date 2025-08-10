// https://www.geeksforgeeks.org/dsa/bottom-view-binary-tree/
import java.util.*;

public class bottomViewUsingHashing {
    static class Node {
        int data;
        Node left, right;

        public Node(int x) {
            data = x;
            left = right = null;
        }
    }

    public static ArrayList<Integer> bottomView(Node root){
        if (root == null) {
            return new ArrayList<>();
        }

        HashMap<Integer, Integer> hash = new HashMap<>();
        int leftmost = 0;

        Queue<Map.Entry<Node, Integer>> q = new LinkedList<>();
        q.offer(new AbstractMap.SimpleEntry<>(root, 0));

        while (!q.isEmpty()) {
            Map.Entry<Node, Integer> top = q.poll();
            Node curr = top.getKey();
            int ind = top.getValue();

            hash.put(ind, curr.data);
            leftmost = Math.min(ind, leftmost);

            if (curr.left != null) { 
                q.offer(new AbstractMap.SimpleEntry<>
                        		(curr.left, ind - 1));
            }
            if (curr.right != null) { 
                q.offer(new AbstractMap.SimpleEntry<>
                        			(curr.right, ind + 1));
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();

        while (hash.containsKey(leftmost)) {
            ans.add(hash.get(leftmost++));
        }

        return ans;
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

        ArrayList<Integer> result = bottomView(root);

        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
