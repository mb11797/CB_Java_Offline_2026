public class DoublyLinkedListDemo{
	public static void main(String[] args){
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
		dll.insertAtHead(1);
		dll.print();

		dll.insertAtHead(3);
		dll.print();

		dll.insertAtIndex(2, 2);
		dll.print();

		dll.insertAtIndex(6, 3);
		dll.print();

		dll.deleteHead();
		dll.print();

		dll.deleteAtIndex(2);
		dll.print();
	}
}