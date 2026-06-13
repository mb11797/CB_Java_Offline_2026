public class DoublyLinkedList<T>{

	public class DLLNode<T>{
		public T data;
		public DLLNode<T> prev;
		public DLLNode<T> next;

		public DLLNode(T data){
			this.data = data;
			this.prev = null;
			this.next = null;
		}
	}

	public DLLNode<T> head;
	public int size;

	public DoublyLinkedList(){
		head = null;
		size = 0;
	}

	public void insertAtHead(T data){
		DLLNode<T> newNode = new DLLNode<>(data);
		if(head == null){
			head = newNode;
			size++;
			return;
		}

		newNode.next = head;
		head.prev = newNode;
		head = newNode;
		size++;
	}

	public void insertAtTail(T data){
		DLLNode<T> temp = head;
		while(temp.next != null){
			temp = temp.next;
		}
		temp.next = new DLLNode<>(data);
		temp.next.prev = temp;
		size++;
	}

	public void insertAtIndex(T data, int idx){
		if(idx == size()){
			insertAtTail(data);
			return;
		}
		DLLNode<T> temp = head;
		int i=0; 
		while(i<idx){
			temp = temp.next;
			i++;
		}

		DLLNode<T> newNode = new DLLNode<>(data);
		newNode.next = temp;
		newNode.prev = temp.prev;
		temp.prev = newNode;
		newNode.prev.next = newNode;
		size++;
	}

	public void deleteHead(){
		if(head == null){
			return;
		}

		if(head.next == null){
			size--;
			head = null;
			return;
		}

		head = head.next;
		head.prev = null;
		size--;
	}

	public void deleteTail(){
		DLLNode<T> tail = head;
		while(tail.next != null){
			tail = tail.next;
		}
		tail.prev.next = null;
		tail.prev = null;
		size--;
	}

	public void deleteAtIndex(int idx){
		if(head == null || idx < 0 || idx >= size){
			return;
		}

		// System.out.println("idx = " + idx + " | size = " + size);
		if(idx == size()-1){
			deleteTail();
			return;
		}

		DLLNode<T> temp = head;
		int i=0; 
		while(i < idx){
			temp = temp.next;
			i++;
		}

		temp.prev.next = temp.next;
		temp.next.prev = temp.prev;
		temp.next = null;
		temp.prev = null;
		size--;
	}

	public int size(){
		return this.size;
	}

	public void print(){
		DLLNode<T> temp = head;
		while(temp != null){
			System.out.print(temp.data + " <->");
			temp = temp.next;
		}
		System.out.println();
		return;
	}

}