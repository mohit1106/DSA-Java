// implement add, remove and peek functions for a circular queue using an array
// add - O(1)   remove - O(1)

public class circularQueue {

    static class Queue{
        static int arr[];
        static int size;
        static int rear;
        static int front;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public static boolean isempty(){
            return rear == -1 && front == -1;
        }

        public static boolean isFull(){
            return (rear + 1) % size == front;
        }

        public static void add(int data){
            if(isFull()){
                System.out.println("queue full");
                return;
            }
            if(front == -1) front = 0; // when adding first element
            rear = (rear+1)%size;
            arr[rear] = data;
        }

        public static int remove(){
            if(isempty()){
                System.out.println("empty");
                return -1;
            }
            int res = arr[front];

            if(rear == front) rear = front = -1;
            else front = (front + 1) % size;
            return res;
        }

        public static int peek(){
            if (isempty()) return -1;
            return arr[front];
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue(3);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.add(4);

        while (!q.isempty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}