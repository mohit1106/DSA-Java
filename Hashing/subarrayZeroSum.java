// find the largets subarray with 0 sum
// i.e find subarrays sum(i+1 to j) = sum(0 to j) - sum(0 to i) = 0
// i.e sum(0 to j) = sum(0 to i)
import java.util.*;

public class subarrayZeroSum {
    public static void main(String[] args) {
        int[] arr = {15,-2,2,-8,1,7,10,23};
        HashMap<Integer, Integer> map = new HashMap<>(); // for (sum, idx) pairs
        int sum = 0;
        int len = 0;

        for(int j=0; j<arr.length; j++){
            sum += arr[j];
            if(map.containsKey(sum)){
                len = Math.max(len, j-map.get(sum));
            } else{
                map.put(sum, j);
            }
        }
        System.out.println("length = "+ len);
    }
}
