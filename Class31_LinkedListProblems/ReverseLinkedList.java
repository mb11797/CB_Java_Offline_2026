import java.util.Scanner;

public class ReverseLinkedList{

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

	public static Node reverseLinkedList(Node head){
		if(head == null){
			return head;
		}

		Node prev = null;
		Node curr = head;
		Node nxt;

		while(curr != null){
			nxt = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nxt;
		}

		return prev;
	}

	public static void main(String[] args){
		Node head = createLinkedList();

		printLinkedList(head);
		head = reverseLinkedList(head);
		printLinkedList(head);
		head = reverseLinkedList(head);
		printLinkedList(head);
	}

}







