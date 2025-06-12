// implement add, remove, isEmpty and peek functions for a queue using two stacks
// add - O(n)   remove - O(1)   peek - O(1)

import java.util.Stack;

public class byTwoStacks {
    static class  Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty(){
            return s1.isEmpty();
        }
        // for adding, first if s1 is not empty then put all elements from s1 to s2
        // then push in s1
        // then again transfer from s2 to s1
        public static void add(int data){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(data);
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        public static int remove(){
            if(isEmpty()) return -1; // if queue is empty
            return s1.pop();
        }
        public static int peek(){
            if(isEmpty()) return -1;
            return s1.peek();
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(0);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
