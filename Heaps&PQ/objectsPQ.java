// storing objects in priority qieue - priority is on the basis of rank here, less rank more priority
// it'll be done by implementing a special inbuilt interface Comparable, so class can comapre its objects.
import java.util.*;

public class objectsPQ {
    static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override 
        public int compareTo(Student s2){
            return this.rank - s2.rank;  // to make rank as priority i.e sort objects on rank basis
            // this(s1).rank - s2.rank  =>  -ve -> s1<s2    +ve -> s2<s1     0 -> s1==s2
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();    // = new PriorityQueue<>(Comparator.reverseOrder()); (to reverse order)
        pq.add(new Student("A", 4));
        pq.add(new Student("B", 5));
        pq.add(new Student("C", 2));
        pq.add(new Student("D", 12));

        while(!pq.isEmpty()){
            System.out.println(pq.peek().name + " -> " + pq.peek().rank);
            pq.remove();
        }
    }
}
