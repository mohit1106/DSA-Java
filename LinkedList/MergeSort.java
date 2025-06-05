public class MergeSort {

    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    ////////////////////////////////////////////////////////////////////
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    /////////////////////////////////////////////////////////////////////
    public void print(){
        if(head == null){
            System.out.println("empty LL");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    /////////////////////////////////////////////////////////////////////
    public void addAtIndex(int idx, int data){
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i=0;
        while(i < idx-1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    //////////////////////////////////////////////////////////////////////
    public int removeFirst(){
        if(size == 0){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1){
            int valToDel = head.data;
            head = tail = null;
            size = 0;
            return valToDel;
        }
        int valToDel = head.data;
        head = head.next;
        size--;
        return valToDel;
    }

    public int removeLast(){
        if (size == 0) {
            System.out.println("empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int valToDel = tail.data;
            head = tail = null;
            size = 0;
            return valToDel;
        }
        Node prev = head;
        for (int i = 0; i < size-2; i++) {
            prev = prev.next;
        }
        int valToDel = prev.next.data; // or tail.data
        prev.next = null;
        tail = prev;
        size--;
        return valToDel;
    }

    //////////////////////////////////////////////////////////////////////
    public int search(int key){
        Node temp = head;
        int i=0;
        while(temp != null){
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public int recursiveSearchHelper(Node head, int key){
        if (head == null) return -1;
        if (head.data == key) return 0;
        int idx = recursiveSearchHelper(head.next, key);
        if(idx == -1) return -1;
        return idx+1;
    }
    public int recursiveSearch(int key){
        return recursiveSearchHelper(head, key);
    }
    
    // reverse a linked list ///////////////////////////////////////////////////////////////////////
    public void reversse(){
        Node prev = null;
        Node curr = head, tail = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // delete nth element from end /////////////////////////////////////////////////////////////////
    public void deleteNthFromEnd(int n){
        int size = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        if(n==size) {
            head = head.next;  // to remove first, because when n == size that means first elemnt
            return;
        }
        int i=1, x = size-n;
        Node prev = head;
        while (i < x) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    //check pallindrome ///////////////////////////////////////////////////////////////////////////
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public boolean checkPallindrome(){
        if(head == null || head.next == null) return true;
        Node midNode = findMid(head);

        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev; //head of 2nd half
        Node left = head; //head of first half

        while (right != null) {
            if(left.data != right.data) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    // detect cycle in linked list ////////////////////////////////////////////////////////////////
    public static boolean hasCycle(){
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // remove cycle from linked list ////////////////////////////////////////////////////////////////
    public static void removeCycle(){
        Node slow = head;
        Node fast = head;
        boolean cycleExists = false;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                cycleExists = true;
                break;
            }
        }
        if(cycleExists == false) return;

        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;
    }

    // merge sort on Linked List ///////////////////////////////////////////////////////////////////
    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node merge(Node head1, Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;
        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }

    public Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node mid = getMid(head);
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        return merge(newLeft, newRight);
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        // Main ll = new Main();
        // ll.addFirst(5);
        // ll.addLast(6);
        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;

        // System.out.println(hasCycle());
        // removeCycle();
        // System.out.println(hasCycle());

        MergeSort ll = new MergeSort();
        ll.addFirst(1);
        ll.addFirst(5);
        ll.addFirst(58);
        ll.addFirst(0);
        ll.addFirst(19);
        ll.print();
        ll.head = ll.mergeSort(ll.head);
        ll.print();
    

    }
}