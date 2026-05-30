public class LinkedListBasic{
	
	public static class Node{
		int data;
		Node next;

		public Node(int data){
			this.data = data;	// this -> mandatory because both data are having same name
			next = null;		// this -> not manadatory here
		}
	}

	public static void printLL(Node head){
		Node temp = head;
		while(temp != null){
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println("null");
		return;
	}


	public static void main(String[] args){
		Node head = new Node(3);
		head.next = new Node(1);
		head.next.next = new Node(2);
		head.next.next.next = new Node(6);
		head.next.next.next.next = new Node(5);

		printLL(head);
	}
}