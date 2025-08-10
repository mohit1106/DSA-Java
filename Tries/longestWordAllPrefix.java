// https://www.geeksforgeeks.org/problems/longest-valid-word-with-all-prefixes/1

/*
Info: 
the word must be in array(already all words in array which are in trie) and all its prefixes also must be in array. first create a trie from all array words.
now trie will have all the unique prefixes stored. 
for all prefixes of a word to be in array, we can manually find all prefix and check if it exist in trie and has endOfWord as true.
but short method is this property - all the characters of that word must have endOfWord as true in trie, because for all prefix, each character of word will come at end once, and so in trie endOfWord must be true for each of them.
so, we need to find longest word from trie for which all characters have endOfWord as true in trie.


approach: 
since all the prefixes of a word are stored in one branch in a trie, so we iterate level wise
and keep taking the branch which is notNull and has endOfWord as true continuously as long as possible
and so we'll get the longest word that has all prefixes in array.
after this do bactracking and check other branch if other has endOfWord as true on same level.
maintain a temp string and final ans, and update final ans only when (temp len > final len), this way well get lexicographically smallest one also,
because in trie we'll go to that branch first which have less idx (beacuse while iterating we iterate from a to z) as character in alphabet, and since we updating only when temp len > final ans, so we'll have the lexicographically smalles one if we came across string of same len having all prefixes in array on that level.
if we need lexicographically larger then simply just reverse the loop like (int i=25; i>=0; i--)
*/

public class longestWordAllPrefix {
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
    public static String ans = "";

    public static void longestWord(Node root, StringBuilder temp){
        if(root == null){
            return;
        }
        for (int i = 0; i < 26; i++) {
            if(root.children[i] != null && root.children[i].endOfWord == true){
                char ch = (char) (i + 'a');
                temp.append(ch);
                if(temp.length() > ans.length()){
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp); // recursive step
                temp.deleteCharAt(temp.length()-1); // backtracking step
            }
        }
    }
    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl","ap", "apply", "apple"};
        for (String word : words) {
            insert(word);
        }
        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }
}
