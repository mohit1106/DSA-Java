import java.util.*;

public class treeMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        System.out.println("normal " + hm); // random order from inserted

        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("India", 100);
        tm.put("China", 150);
        tm.put("US", 50);
        tm.put("Indonesia", 200);

        System.out.println("treemap " + tm);  //sorted order as inserted
    }
}
