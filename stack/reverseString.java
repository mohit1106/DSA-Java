// reverse a string using a stack

import java.util.*;
public class reverseString {

    public static String reverseStr(String str){
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            s.push(str.charAt(i));
        }
        StringBuilder res = new StringBuilder();
        while(!s.isEmpty()){
            res.append(s.pop());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String str = "helloWorld";
        System.out.println(reverseStr(str));
    }
}