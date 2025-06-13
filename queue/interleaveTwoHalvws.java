// interleave two halves of a queue of even length

import java.util.*;
public class interleaveTwoHalvws {
    public static void main(String[] args) {
        Queue<Integer> orgqueue = new LinkedList<>();
        orgqueue.add(1);
        orgqueue.add(2);
        orgqueue.add(3);
        orgqueue.add(4);
        orgqueue.add(5);
        orgqueue.add(6);


        int orgsize = orgqueue.size();
        Queue<Integer> firsthalf = new LinkedList<>();
        for(int i=0; i<orgsize/2; i++){
            firsthalf.add(orgqueue.peek());
            orgqueue.remove();
        }

        // we take first element of firsthalf and add it to last of original then remove first
        // then take first element of original and add it to last of original then remove first
        // i.e wee keep modifying in original queue instead of creating new res queue
        while (!firsthalf.isEmpty()) {
            orgqueue.add(firsthalf.remove());
            orgqueue.add(orgqueue.remove());
        }

        while(!orgqueue.isEmpty()){
            System.out.print(orgqueue.remove() + " ");
        }
    }
}
