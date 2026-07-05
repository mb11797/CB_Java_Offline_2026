public class GenericQueue<T>{

	private T[] arr;
	private int front;
	private int rear;
	private int maxSize;
	private int curSize;
	
	public GenericQueue(int maxSize){
		this.maxSize = maxSize;
		arr = (T[]) new Object[maxSize];
		this.curSize = 0;
		this.front = 0;
		this.rear = maxSize-1;
	}

	public void offer(T data){
		// offer -> push at last
		if(isFull()){
			System.out.println("Queue Overflow. " + data + " not pushed");
			return;
		}
		rear = (rear + 1) % maxSize;
		arr[rear] = data;
		curSize++;
	}

	public T poll(){
		// poll -> remove from front
		if(isEmpty()){
			System.out.println("Queue is Empty...");
			return null;
		}
		T poppedElmt = arr[front];
		front = (front + 1) % maxSize;
		curSize--;
		return poppedElmt;
	}

	public T peek(){
		// peek -> read and return front
		if(isEmpty()){
			System.out.println("Queue is Empty...");
			return null;
		}
		return arr[front];
	}

	public int size(){
		return curSize;
	}

	public boolean isFull(){
		return curSize == maxSize;
	}

	public boolean isEmpty(){
		return curSize == 0;
	}
}



