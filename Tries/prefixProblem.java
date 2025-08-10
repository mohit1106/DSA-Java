// https://www.geeksforgeeks.org/dsa/find-all-shortest-unique-prefixes-to-represent-each-word-in-a-given-list/
// shortest prefix that can uniquely identify that word
// first create a trie of the array words ->  also track frequency of each node
// freq is the no. of all branches emerging from that node(not necessarily only first child, it can be common and then divides when go down), i.e from that node, number of all leafs that can be reached downward
// if freq beacme 1 that means, that char of word is unique now

public class prefixProblem {
    static class Node{
        Node[] children = new Node[26];
        boolean endOfWord = false;
        int freq; // how many words pass through this node

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            freq= 1;
        }
    }

    public static Node root = new Node();

    // insert function
    public static void insert(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            } else {
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }
        curr.endOfWord = true;
    }

    // Find shortest unique prefix for a word
    public static String getUniquePrefix(String word) {
        Node curr = root;
        StringBuilder prefix = new StringBuilder();
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            prefix.append(word.charAt(level));
            if (curr.children[idx].freq == 1) {
                // found the unique point
                break;
            }
            curr = curr.children[idx];
        }
        return prefix.toString();
    }

    public static void main(String[] args) {
        String[] arr = {"zebra", "dog", "duck", "dove"};
        for (String word : arr) {
            insert(word);
        }

        for (String word : arr) {
            System.out.print(getUniquePrefix(word) + " ");
        }
    }
}
