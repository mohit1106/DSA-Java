// first non-repeating letter in a stream of lowercase characters

import java.util.*;
public class firstNonRepeating {
    public static void main(String[] args) {
        String str = "aabccxb";

        int[] freq = new int[26];
        Queue<Character> q = new LinkedList<>();
        for(char c : str.toCharArray()){
            q.add(c);
            freq[c-'a']++;

            while(!q.isEmpty() && freq[q.peek()-'a'] > 1) {
                q.remove();
            }
            if(q.isEmpty()) System.out.print(-1 + " ");
            else System.out.print(q.peek() + " ");
        }
    }
}
