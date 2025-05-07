// find and print all permutations of a string
// time - O(n*n!)

public class permutations {
    public static void findPermutations(String str, String res){
        if(str.length() == 0){
            System.out.println(res);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i); // taking current character
            String newStr = str.substring(0, i) + str.substring(i+1); // removing the current char
            findPermutations(newStr, res + curr);

        }
    }

    public static void main(String[] args) {
        String str = "abc";
        findPermutations(str, "");
    }
}