// find number of subarray whose sum equal to K
// sum(i+1 to j) = sum(0 to j) - sum(0 to i), where j > i
// sum(i to j) = sum(0 to j) - sum(0 to i-1), where j > i
// find all subarray whose sum(0 to j) - sum(0 to i) = k
// i.e sum(0 to j) - k = sum(0 to i) which is already stored

// approach store pairs (sum, count) in map
// also add (0, 1) pair already foe cases when sum(0 to j) - k = 0 
import java.util.*;

public class subarraySumEqualK {
    public static void main(String[] args) {
        int[] arr = {10,2,-2,-20,10};
        int k = -10;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum=0, ans=0;
        for(int j=0; j<arr.length; j++){
            sum += arr[j];
            if(map.containsKey(sum-k)){
                ans += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        System.out.println(ans);
    }
}
