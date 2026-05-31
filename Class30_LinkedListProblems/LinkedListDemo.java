import java.util.Scanner;

public class LinkedListDemo{
	public static void main(String[] args){
		LinkedList ll = new LinkedList();		// head -> null

		ll.print();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter no of nodes: ");
		int n = scanner.nextInt();

		System.out.println("Enter Linked List nodes: ");
		while(n-- > 0){
			ll.insertAtHead(scanner.nextInt());	
			ll.print();			
		}

		System.out.println("Size of Linked List = " + ll.size());


		ll.insertAtTail(7);
		ll.print();

		// insertAtIndex(data, idx)
		ll.insertAtIndex(8, 2);
		ll.print();

		// insertAtIndex(data, idx)
		ll.insertAtIndex(11, 50);
		ll.print();

		ll.deleteHead();
		ll.print();

		ll.deleteTail();
		ll.print();

		ll.deleteAtIndex(3);
		ll.print();

		ll.deleteAtIndex(5);
		ll.print();

		int key = 6;
		if(ll.search(key)){
			System.out.println(key + " found");
		}
		else{
			System.out.println(key + " not found");
		}

	}
}