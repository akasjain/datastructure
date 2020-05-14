package ds.linkedlist;



public class SortList012 {

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    private static Node sort(Node head) {

        Node prev = null;
        Node firstZero = head;
        Node lastTwo = head;
        Node temp = head;

        while(temp.next != null) {
            if(temp.data == 2) {
                lastTwo = temp;
            } else if(temp.data == 0 && firstZero == null) {
                firstZero = temp;
            }
            temp = temp.next;
        }






        return null;
    }
    public static void main(String[] args) {
        //2->1->2->1->1->2->0->1->0
        Node head = new Node(2);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(1);
        head.next.next.next.next.next = new Node(2);
        head.next.next.next.next.next.next = new Node(0);
        head.next.next.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next.next.next = new Node(0);

    }

}
