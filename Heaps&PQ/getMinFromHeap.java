// peek function of heap i.e get minimum element from the heap
// min is at 0th element in array or root node in tree

import java.util.*;

public class getMinFromHeap {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        // O(1) - to peek
        public int peek(){
            return arr.get(0);
        }

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
