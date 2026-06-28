public class ArrayStack<T> implements Stack<T>{

	private T[] arr;		// Declare
	private int maxSize;
	private int top;

	public Stack(int maxSize){
		arr = (T[]) new Object[maxSize];
		this.top = -1;
		this.maxSize = maxSize;
	}

	public void push(T data){
		if(top == maxSize-1){
			System.out.println("Cant push " + data + " due to Stack Overflow...");
			return;
		}

		top++;
		arr[top] = data;
	}

	public T peek(){
		if(isEmpty()){
			System.out.println("Empty Stack...");
			return null;
		}
		return arr[top];
	}

	public T pop(){
		if(isEmpty()){
			System.out.println("Nothing to pop due to Stack Underflow...");
			return null;
		}

		T topEl = arr[top];
		top--;
		return topEl;
	}

	public int size(){
		return top+1;
	}

	public boolean isEmpty(){
		return top == -1;
	}
}