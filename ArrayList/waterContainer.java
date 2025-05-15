// for given n lines on x-axis, use 2 lines to form a container such that it holds maximum water
// height of the lines are given as input


// two pointer approach - O(n)
import java.util.*;

public class waterContainer {
    public static int water(ArrayList<Integer> height){
        int max = 0;
        int n = height.size();
        int i=0, j=n-1;
        while(i < j){
            int waterStored = (j-i) * Math.min(height.get(i), height.get(j));
            max = Math.max(max, waterStored);

            if(height.get(i) < height.get(j)){
                i++;
            }else{
                j--;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(water(height));
    }
}





/* 
// bruteforce approach - O(n^2)
import java.util.*;

public class waterContainer {
    public static int water(int[] height){
        int max = 0;
        for(int i=0; i<height.length-1; i++){
            for (int j = i+1; j < height.length; j++) {
                int waterStored = (j - i) * (Math.min(height[i], height[j])); // width * height
                if(waterStored>max) max = waterStored;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(water(height));
    }
}
*/