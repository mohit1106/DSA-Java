// https://www.geeksforgeeks.org/problems/count-of-distinct-substrings/1

// uniqe substrings = all unique prefix of all suffix (= all unique suffix of all prefix)
// tries DS stores the unique prefixes of all words
// no. of unique prefixes in trie = count of nodes in trie (including root which represent empty)

// approach - store all the suffixes in trie and then count all unique prefixes of all suffix i.e count no.of nodes
//            and this total count of unique prefixes of all suffix = count of unique substrings


public class countUniqueSubstrings {
    static class Node{
        Node[] children = new Node[26];
        boolean endOfWord = false;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.endOfWord = true;
    }

    public static boolean search(String key) {
        Node curr = root;
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.endOfWord == true;
    }

    // core implementation
    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if(root.children[i] != null){
                count += countNodes(root.children[i]);
            }
        }
        return count + 1;
    }
    public static void main(String[] args) {
        String str = "apple";

        // add all suffixes in trie
        for (int i = 0; i < str.length(); i++) {
            insert(str.substring(i));
        }

        System.out.println(countNodes(root));
    }
}
