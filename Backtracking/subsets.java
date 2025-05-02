// find and print all subsets of a given string
// time - O(n * 2^n)
// space - O(n)


import java.util.*;
public class subsets {
    public static void findSubsets(String str, String res, int i){
        if (i == str.length()) {
            System.out.println(res);
            return;
        }

        // character is selected
        findSubsets(str, res+str.charAt(i), i+1); 
        // if using stringbuilder then we'll have to delete the already added element also.
        // character is not selected
        findSubsets(str, res, i+1);
    }
    public static void main(String[] args) {
        String str = "abc";
        findSubsets(str, "", 0);
    }    
}