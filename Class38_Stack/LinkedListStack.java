public class LinkedListStack<T> implements Stack<T>{

	private class Node<T>{
		T data;
		Node<T> next;

		public Node(T data){
			this.data = data;
			this.next = null;
		}
	}

	private Node<T> head;
	private int curSize;

	public LinkedListStack(){
		head = null;
		this.curSize = 0;
	}

	public void push(T data){
		Node<T> newNode = new Node<>(data);

		if(head == null){
			head = newNode;
		}
		else{
			newNode.next = head;
			head = newNode;
		}
		curSize++;
		return;
	}

	public T pop(){
		if(isEmpty()){
			System.out.println("Nothing to pop due to Stack Underflow...");
			return null;
		}
		T poppedEl = head.data;
		head = head.next;
		curSize--;
		return poppedEl;
	}

	public T peek(){
		if(isEmpty()){
			System.out.println("Empty Stack...");
			return null;
		}
		return head.data;
	}

	public int size(){
		return curSize;
	}

	public boolean isEmpty(){
		return curSize == 0;
	}

}