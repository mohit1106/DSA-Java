import java.util.*;

public class insertInHeap {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        // O(log n) - to add
        public void add(int data){
            arr.add(data);

            int childIdx = arr.size()-1;
            int parentIdx = (childIdx - 1)/2;

            while(arr.get(childIdx) < arr.get(parentIdx)){
                int temp = arr.get(childIdx);
                arr.set(childIdx, arr.get(parentIdx));
                arr.set(parentIdx, temp);    
                
                childIdx = parentIdx;
                parentIdx = (childIdx-1)/2;
            }
        }
    }
    public static void main(String[] args) {
        
    }
}
