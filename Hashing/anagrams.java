// https://leetcode.com/problems/valid-anagram/description/
import java.util.*;

public class anagrams {
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(char c : t.toCharArray()){
            if(map.get(c) != null ){
                if(map.get(c) ==1) map.remove(c);
                else map.put(c, map.get(c)-1);
            } else{
                return false;
            }
        }
        return map.isEmpty();
    }
    public static void main(String[] args) {
        String s = "race";
        String t = "care";

        System.out.println(isAnagram(s, t));
    }
}
