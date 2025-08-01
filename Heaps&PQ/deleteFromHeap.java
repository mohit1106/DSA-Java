// delete from heap i.e delete minimum element from heap and then maintain min/max heap
import java.util.*;

public class deleteFromHeap {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        public int remove(){
            int data = arr.get(0);

            // swap first and last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            arr.remove(arr.size()-1); // delete last
            
            heapify(0); // call heapify for root node
            return data;
        }

        private void heapify(int i){
            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i; //idx of minimum value i.e root - assuming

            if(left < arr.size() && arr.get(minIdx) > arr.get(left)){  // // left < arr.size() - for leaf nodes, left and right dont exist 
                minIdx = left;
            } 
            if(right < arr.size() && arr.get(minIdx) > arr.get(right)){
                minIdx = right;
            }

            if(minIdx != i){
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        public boolean isEmpty(){
            return arr.size() == 0;
        }

        // O(1) - to peek
        public int peek(){
            return arr.get(0);
        }

        // O(log n) - to add
        public void add(int data){
            arr.add(data);

            int childIdx = arr.size()-1;
            int parentIdx = (childIdx - 1)/2;

            while(childIdx > 0 && arr.get(childIdx) < arr.get(parentIdx)){
                int temp = arr.get(childIdx);
                arr.set(childIdx, arr.get(parentIdx));
                arr.set(parentIdx, temp); 
                
                childIdx = parentIdx;
                parentIdx = (childIdx-1)/2;
            }
        }
    }
    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(1); 
        h.add(5);

        while (!h.isEmpty()) {
            System.out.println(h.peek());
            h.remove();
        }
    }
}
