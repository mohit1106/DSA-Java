// https://www.geeksforgeeks.org/problems/longest-valid-word-with-all-prefixes/1

// the word must be in array(already all words in array which are in trie) and all its prefixes also must be in array. first create a trie from all array words.
// now trie will have all the unique prefixes stored. 
// for all prefixes of a word to be in array, we can manually find all prefix and check if it exist in trie and has endOfWord as true.
// but short method is this property - all the characters of that word must have endOfWord as true in trie, because for all prefix, each character of word will come at end once, and so in trie endOfWord must be true for each of them.
// so, we need to find longest word from trie for which all characters have endOfWord as true in trie.



public class longestWordAllPrefix {
    public static void main(String[] args) {
        
    }
}
