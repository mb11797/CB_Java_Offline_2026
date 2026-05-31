import java.util.Scanner;

public class MiddleOfLinkedList{

	public static Node createLinkedList(){
		System.out.println("Enter n: ");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();		// n = 5

		Node head = null;
		Node tail = head;
		System.out.println("Enter nodes: ");
		while(n-- > 0){		// n = 5
			int data = scanner.nextInt();
			Node newNode = new Node(data);
			if(tail == null){
				head = tail = newNode;
			}
			else{
				tail.next = newNode;
				tail = tail.next;
			}
		}

		return head;
	}

	public static void printLinkedList(Node head){
		System.out.println("Printing Linked List...");
		Node temp = head;
		while(temp != null){
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println("null");
		return;
	}

	public static Node middleOfLinkedList(Node head){
		Node slow = head;
		Node fast = head;

		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public static void main(String[] args){
		Node head = createLinkedList();

		printLinkedList(head);
		Node mid = middleOfLinkedList(head);
		printLinkedList(mid);
	}

}







