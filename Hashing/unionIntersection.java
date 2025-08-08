// find union(all unique elemnts in both arr) and intersection( common elements in both arr) of two given arrays
import java.util.*;

public class unionIntersection {
    public static void main(String[] args) {
        int[] arr1 = {7,3,9};
        int[] arr2 = {6,3,9,2,9,4};

        // for union
        HashSet<Integer> set = new HashSet<>();
        for(int a : arr1) set.add(a);
        for(int b : arr2) set.add(b);
        System.out.println("union " + set);

        //for intersection(common and unique in both)
        set.clear();
        ArrayList<Integer> res = new ArrayList<>();
        for(int a : arr1) set.add(a);
        for(int b : arr2){
            if(set.contains(b)) {
                res.add(b);
                set.remove(b);
            }
        }
        System.out.println("intersection "+ res);
    }
}
