public class LinkedList{
	Node head;	// global

	public LinkedList(){
		head = null;
	}

	public int size(){
		int size = 0;
		Node temp = head;
		while(temp != null){
			size++;
			temp = temp.next;
		}
		return size;
	}

	// Operations: 
	public void insertAtHead(int data){
		System.out.println("Inserting at Head: data = " + data);
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
		System.out.println();
	}

	public void insertAtTail(int data){
		System.out.println("Inserting at Tail: data = " + data);
		if(head == null){
			insertAtHead(data);
			return;
		}

		Node temp = head;
		while(temp != null && temp.next != null){
			temp = temp.next;
		}

		// temp -> pointing to tail node
		temp.next = new Node(data);
		System.out.println();
	}

	public void insertAtIndex(int data, int idx){
		System.out.println("Inserting at idx = " + idx + " : data = " + data);
		if(head == null || idx < 0 || idx > size()){
			System.out.println("Index out of Bounds");
			return;
		}
		Node newNode = new Node(data);
		Node temp = head;
		int i=0; 
		while(i < idx-1){
			temp = temp.next;
			i++;
		}
		newNode.next = temp.next;
		temp.next = newNode;
		System.out.println();
	}

	public void print(){
		System.out.println("Printing Linked List: ");
		System.out.print("head -> ");
		Node temp = head;
		while(temp != null){
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.println("null");
		System.out.println();
		return;	
	}
}