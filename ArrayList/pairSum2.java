// find if any pair in a sorted and rotated arraylist has a target sum


// two pointer approach - O(n)
import java.util.ArrayList;

public class pairSum2 {
    public static boolean pair(ArrayList<Integer> list, int target){
        int n = list.size();
        int pivot =  -1;
        for(int i=0; i<n; i++){
            if(list.get(i) > list.get(i+1)){
                pivot = i;
                break;
            }
        }

        int i = pivot+1, j = pivot;
        while (i != j) {
            if(list.get(i) + list.get(j) == target) return true;
            else if(list.get(i) + list.get(j) < target) i = (i+1)%n;
            else j = (n+j-1)%n;
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        int target = 16;
        System.out.println(pair(list, target));
    }
}