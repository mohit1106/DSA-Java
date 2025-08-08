import java.util.*;

public class hashSet {

    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(2);
        set.add(4);

        
        // System.out.println(set); // [1, 2, 4]
        // System.out.println(set.size()); // 3
        // set.clear();
        // System.out.println(set.size()); // 0
        // System.out.println(set.isEmpty()); // true
 

        Iterator it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        for (Integer a : set) {
            System.out.println(a);
        }
    }
}