package ds.linkedlist;

public class FlattenListDepthWise {
    static class Node {
        int data;
        Node next;
        Node down;

        Node(int data) {
            this.data = data;
        }
    }
    static Node last;
    public static Node flattenListDepthWise(Node node) {

        if(node == null)
            return null;

        Node next = node.next;
        last = node;

        if(node.down != null) {
            node.next = flattenListDepthWise(node.down);
        }

        if(next != null)
            last.next = flattenListDepthWise(next);

        return node;
    }

    public static void main(String args[]) {
        Node head=new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.down = new Node(7);
        head.next.down.down = new Node(9);
        head.next.down.down.down = new Node(14);
        head.next.down.down.down.down= new Node(15);
        head.next.down.down.down.down.next= new Node(23);
        head.next.down.down.down.down.next.down = new Node(24);
        head.next.down.next = new Node(8);
        head.next.down.next.down = new Node(16);
        head.next.down.next.down.down= new Node(17);
        head.next.down.next.down.down.next= new Node(18);
        head.next.down.next.down.down.next.next= new Node(19);
        head.next.down.next.down.down.next.next.next
                = new Node(20);
        head.next.down.next.down.down.next.next.next.down
                = new Node(21);
        head.next.down.next.next = new Node(10);
        head.next.down.next.next.down = new Node(11);
        head.next.down.next.next.next = new Node(12);

        head = flattenListDepthWise(head);
        printFlattenNodes(head);
    }

    public static void printFlattenNodes(Node head)
    {
        Node curr=head;
        while(curr!=null)
        {
            System.out.print(curr.data+" ");
            curr = curr.next;
        }

    }

}
