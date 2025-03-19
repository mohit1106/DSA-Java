import java.util.*;

public class Constructors {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Mohit";
        s1.rollNo = 1;
        s1.pass = "abcd";

        Student s2 = new Student(s1);
        System.out.println(s2.name);
    }
}

class Student{
    String name;
    int rollNo;
    String pass;

    // copy constructor
    Student(Student s1){
        this.name =  s1.name;
        this.rollNo = s1.rollNo;
    }

    //unparametrized constructore
    Student(){
        System.out.println("it is an empty constructur");
    }
}
