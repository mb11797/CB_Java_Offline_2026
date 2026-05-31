import java.util.Scanner;

public class PalindromicLinkedList{

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

	public static Node middleOfLinkedList(Node head){
		Node slow = head;
		Node fast = head;

		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public static boolean isPalindrome(Node head){
		// Step-1: Find mid
		Node slow = head;
		Node fast = head;

		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}

		// slow -> mid
		slow = reverseLinkedList(slow);
		fast = head;

		while(slow != null && fast != null){
			if(slow.data != fast.data){
				return false;
			}
			slow = slow.next;
			fast = fast.next;
		}

		return true;
	}

	public static boolean isPalindromeAlternative(Node head){
		Node midNode = middleOfLinkedList(head);

		Node p1 = head;
		Node p2 = reverseLinkedList(midNode);

		while(p1 != null && p2 != null){
			if(p1.data != p2.data)
				return false;
			p1 = p1.next;
			p2 = p2.next;
		}

		return true;
	}


	public static void main(String[] args){
		Node head = createLinkedList();

		printLinkedList(head);
		System.out.println((isPalindrome(head) ? "Palindromic Linked List" 
			: "Non-Palindromic Linked List"));
	}

}







