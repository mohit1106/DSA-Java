// implement add, remove, isEmpty and peek functions for a queue using an array
// add - O(1)   remove - O(n)

public class byArray {

    static class Queue{
        static int arr[];
        static int size;
        static int rear;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public static boolean isempty(){
            return rear == -1;
        }

        public static void add(int data){
            if(rear == size-1){
                System.out.println("queue full");
                return;
            }
            rear = rear+1;
            arr[rear] = data;
        }

        public static int remove(){
            if(isempty()){
                System.out.println("empty");
                return -1;
            }
            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i+1];
            }
            rear = rear - 1;
            return front;
        }

        public static int peek(){
            if (isempty()) return -1;
            return arr[0];
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(0);
        q.add(2);
        q.add(3);

        while (!q.isempty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}