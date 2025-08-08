import java.util.HashSet;

public class countDistincts {
    public static void main(String[] args) {
        int[] nums = {4,3,2,5,6,7,3,4,2,1};

        HashSet<Integer> set = new HashSet<>();
        for (int a : nums) {
            set.add(a);
        }
        System.out.println(set.size());
    }
}
