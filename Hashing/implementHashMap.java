import java.util.*;

public class implementHashMap {
    static class HashMap<K, V> { 
        private class Node{
            K key;
            V value;

            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n; // n i.e total nodes
        private int N;
        private LinkedList<Node> buckets[]; // N i.e array or total buckets

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[4]; // i.e bucket/array of length 4 of type linkedlist, here we dont need to tell type of linked list because of that suppress warning
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>(); // creating a new empty linkedList on each idx of array
            }
        }

        private int hashFunction(K key){
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int searchInLL(K key, int bi){
            LinkedList<Node> ll = buckets[bi];
            int di = 0;

            for(int i=0;i<ll.size(); i++){
                Node node = ll.get(i);
                if(node.key == key){
                    return di;
                }
                di++;
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N*2]; //empties and give size of 2*N
            N = 2*N;
            for(int i=0; i<buckets.length; i++){
                buckets[i] = new LinkedList<>(); // initialise the bucket with empty LLs
            }

            // add previous nodes in new bucket of more size
            for(int i=0; i<oldBucket.length; i++){
                LinkedList<Node> ll = oldBucket[i];
                for(int j=0; j<ll.size(); j++){
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        // put() - O(lambda) ////////////////////////////////////////////////////////////////////////////////
        public void put(K key, V value){
            int bi = hashFunction(key); // bucket index - can be in range of 0 to size-1
            int di = searchInLL(key, bi); // data index - index of key in that bucket (if doesnt exist then -1) of idx bi 

            if(di != -1){
                Node node = buckets[bi].get(di);
                node.value = value;
            } else{
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lambda = (double) n/N;
            if(lambda > 2.0){ // 2.0 is threshold value
                rehash();
            }
        }

        // containsKey() - O(1) /////////////////////////////////////////////////////////////////////////////////
        public boolean containsKey(K key){
            int bi = hashFunction(key); 
            int di = searchInLL(key, bi);  

            if(di != -1){
                return true;
            } else{
                return false;
            }
        }

        // remove() - O(1) ////////////////////////////////////////////////////////////////////////////////////
        public V remove(K key){
            int bi = hashFunction(key); 
            int di = searchInLL(key, bi);  

            if(di != -1){
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            } else{
                return null;
            }
        }

        // get() - O(1) /////////////////////////////////////////////////////////////////////////////////////
        public V get(K key){
            int bi = hashFunction(key); 
            int di = searchInLL(key, bi);  

            if(di != -1){
                Node node = buckets[bi].get(di);
                return node.value;
            } else{
                return null;
            }
        }

        // keySet() ///////////////////////////////////////////////////////////////////////////////////////
        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for(Node node : ll){
                    keys.add(node.key);
                }
            }
            return keys;
        }

        // isEmpty() ///////////////////////////////////////////////////////////////////////////////////////
        public boolean isEmpty() {
            return n==0;
        }
    } 
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Nepal", 50);

        ArrayList<String> keys = hm.keySet();
        for (String key : keys) {
            System.out.println(key);
        }

        System.out.println(hm.get("India"));
        hm.remove("India");
        System.out.println(hm.get("India"));
    }
}
