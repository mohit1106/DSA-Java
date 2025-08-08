import java.util.*;

public class linkedHashSet {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Noida");
        System.out.println(cities);

        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Delhi");
        lhs.add("Mumbai");
        lhs.add("Noida");
        System.out.println(lhs);

        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(5);
        ts.add(2);
        ts.add(4);
        ts.add(1);
        System.out.println(ts);

    }
}
