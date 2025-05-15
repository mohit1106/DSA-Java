import java.util.ArrayList;

public class main {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        ArrayList<Integer> innerList1 = new ArrayList<>();
        innerList1.add(1);
        innerList1.add(2);
        innerList1.add(3);

        ArrayList<Integer> innerList2 = new ArrayList<>();
        innerList2.add(4);      
        innerList2.add(5);
        innerList2.add(6);
        innerList2.add(7);

        ArrayList<Integer> innerList3 = new ArrayList<>();
        innerList3.add(6);
        innerList3.add(9);
        innerList3.add(5);
        innerList3.add(7);
        innerList3.add(2);

        list.add(innerList1);
        list.add(innerList2);
        list.add(innerList3);

        System.out.println(list);
        
        for (int i = 0; i < list.size(); i++) {
            ArrayList<Integer> curr = list.get(i);
            for (int j = 0; j < curr.size(); j++) {
                System.out.print(curr.get(j) + " ");
            }
            System.out.println();
        }
    }
}