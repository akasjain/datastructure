package linkedlist;

public class DeleteNodeByReference {
 public static void deleteNodeByReference(LinkedListNode node) {
	
	 LinkedListNode temp = null;
	 if(node.getNext() != null) {
		 temp = node.getNext();
		 System.out.println("Deleted data : " + node.getData());
		 node.setData(temp.getData());
		 node.setNext(temp.getNext());
	 }
 }
}
