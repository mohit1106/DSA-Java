// given an integer array of size n, find all elements that appear strictly more than floor(n/3) times.
import java.util.*;

public class majorityElement {
    public static void main(String[] args) {
        int[] nums = {1,3,2,5,1,3,1,5,1};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        for (int key : map.keySet()) {
            if(map.get(key) > nums.length/3){
                System.out.println(key);
            }
        }
    }
}
