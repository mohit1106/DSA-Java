import java.util.*;

public class main {
    public static void update(int[] marks){
        for (int i = 0; i < marks.length; i++) {
            marks[i] = marks[i] + 1;
        }
    }

    public static void main(String[] args) {
        int marks[] = {4, 5, 6};
        update(marks);
        for (int i : marks) {
            System.out.println(i);
        }
    }
}