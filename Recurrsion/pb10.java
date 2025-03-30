// remove all duplicate characters in a string where all the characters are from 'a' to 'z', there are no special characters.

public class pb10 {
    public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[]){ //map is an array that stores if characters have already have appeared or not
        if(idx == str.length()) {
            System.out.println(newStr);
            return;
        }
        char currentChar = str.charAt(idx);
        if(map[currentChar - 'a'] == true){
            removeDuplicates(str, idx + 1, newStr, map);
        } else {
            map[currentChar - 'a'] = true;
            removeDuplicates(str, idx + 1, newStr.append(currentChar), map);
        }

    } 
    public static void main(String[] args) {
        String str = "missisipi";
        StringBuilder newStr = new StringBuilder("");
        boolean[] map = new boolean[26];
        removeDuplicates(str, 0, newStr, map);
    }
}
