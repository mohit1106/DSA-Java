// find if any pair in a sorted ArrayList has a target sum

// two pointer approach - O(n)
import java.util.*;
public class pairSum1 {
    public static boolean pair(ArrayList<Integer> list, int target){
        int n = list.size();
        int i=0, j=n-1;
        while(i < j){
            int sum = list.get(i) + list.get(j);
            if (sum == target) return true;
            else if(sum > target) j--;
            else i++;
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        int target = 5;
        System.out.println(pair(list, target));
    }
}





/*
// bruteforce approach - O(n^2)
import java.util.ArrayList;
public class pairSum1 {

    public static boolean pair(ArrayList<Integer> list, int target){
        for(int i=0; i<list.size()-1; i++){
            for(int j=i+1; j<list.size(); j++){
                if(list.get(i) + list.get(j) == target) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        int target = 5;
        System.out.println(pair(list, target));
    }
}
*/