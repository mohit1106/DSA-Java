import java.util.*;
public class shortestPath {
    public static void main(String[] args) {
        String directions = "wneenesennn";

        int x = 0, y = 0;
        for (char dir : directions.toCharArray()) {
            switch (dir) {
                case 'w': y++; break;
                case 'e': y--; break;
                case 'n': x++; break;
                case's': x--; break;
            }
        }
        System.out.println("current position: " + x + " " + y);

        double distance = Math.sqrt(Math.abs(x)*Math.abs(x) + Math.abs(y)*Math.abs(y));
        System.out.println(distance);
    }
}
