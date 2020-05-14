package ds.linkedlist;



class MyLinkedList {

    class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    /** Initialize your data structure here. */
    Node head;
    public MyLinkedList() {
        head = null;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node temp = head;
        while(index > 0 && temp!= null) {
            temp = temp.next;
            index--;
        }
        return temp == null? -1 : temp.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node = new Node(val);
        Node temp = head;
        if(temp == null) {
            temp = node;
            return;
        }
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index == 0) {
            addAtHead(val);
            return;
        }
        Node node = new Node(val);
        Node temp = head;
        while(index > 1 && temp!= null) {
            temp = temp.next;
            index--;
        }
        if(temp == null) {
            return;
        }
        node.next = temp.next;
        temp.next = node;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {

        if(head == null)
            return;

        if(index == 0) {
            head = head.next;
            return;
        }

        Node temp = head;
        while(index > 1 && temp.next!= null) {
            temp = temp.next;
            index--;
        }
        if(temp.next == null)
            return;

        temp.next = temp.next.next;
    }

    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        /*obj.addAtHead(1);
        obj.addAtTail(3);
        obj.addAtIndex(1, 2);
        System.out.println(obj.get(1));
        obj.deleteAtIndex(1);
        System.out.println(obj.get(1));*/



        obj.addAtHead(2);
        obj.deleteAtIndex(1);
        obj.addAtHead(2);
        obj.addAtHead(7);
        obj.addAtHead(3);
        obj.addAtHead(2);
        obj.addAtHead(5);
        obj.addAtTail(5);
        System.out.println(obj.get(5));
        obj.deleteAtIndex(6);
        obj.deleteAtIndex(4);
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
