import java.util.Scanner;

public class RecursiveReverseLinkedList{

	public static Node createLinkedList(){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		Node head = null;
		Node temp = head;
		while(n-- > 0){
			int data = scanner.nextInt();
			Node newNode = new Node(data);

			if(head == null){
				head = temp = newNode;
			}
			else{
				temp.next = newNode;
				temp = temp.next;
			}
		}
		return head;
	}

	public static Node createLinkedListRobust(){
		Scanner scanner = new Scanner(System.in);
		int data = scanner.nextInt();

		Node head = null;
		Node temp = head;
		while(data != -1){
			Node newNode = new Node(data);

			if(head == null){
				head = temp = newNode;
			}
			else{
				temp.next = newNode;
				temp = temp.next;
			}

			data = scanner.nextInt();
		}

		return head;
	}

	public static void printLinkedList(Node head){
		Node temp = head;
		while(temp != null){
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println("null");
	}

	public static Node reverseLinkedListRecursive(Node head){
		if(head == null || head.next == null){
			return head;
		}

		Node reverseHead = reverseLinkedListRecursive(head.next);

		head.next.next = head;
		head.next = null;

		return reverseHead;
	}

	public static void main(String[] args){
		Node head = createLinkedListRobust();

		printLinkedList(head);
		Node reverseHead = reverseLinkedListRecursive(head);
		printLinkedList(reverseHead);
	}

}







