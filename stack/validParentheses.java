// https://leetcode.com/problems/valid-parentheses/description/
// time - O(n)

import java.util.*;
public class validParentheses {
    public static boolean isValid(String str){
        Stack<Character> s = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char curr = str.charAt(i);
            if(curr == '(' || curr == '{' || curr == '['){
                s.push(curr);
            } else{
                if(s.isEmpty()) return false;
                if(isPair(s.peek(), curr)) s.pop();
                else return false; 
            }
        }
        return s.isEmpty();
    }

    public static boolean isPair(char open, char close){
        return (open=='(' && close==')') || 
               (open=='{' && close=='}') ||
               (open=='[' && close==']');
    }

    public static void main(String[] args) {
        String str = "({})[{}]";
        System.out.println(isValid(str));

    }
}