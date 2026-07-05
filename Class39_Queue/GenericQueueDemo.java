public class GenericQueueDemo{
	public static void main(String[] args){
		GenericQueue<Integer> q = new GenericQueue<>(5);

		q.offer(3);
		System.out.println("Peek: " + q.peek() + " | Size = " + q.size());
		q.offer(1);
		System.out.println("Peek: " + q.peek() + " | Size = " + q.size());
		q.offer(2);
		System.out.println("Peek: " + q.peek() + " | Size = " + q.size());
		q.offer(6);
		System.out.println("Peek: " + q.peek() + " | Size = " + q.size());

		int polledElmt = q.poll();		// pop / remove
		System.out.println("Polled Element: " + polledElmt + " | Size = " + q.size());
		System.out.println("Peek: " + q.peek() + " | Size = " + q.size());
		
		q.offer(5);
		System.out.println("Peek: " + q.peek() + " | Size = " + q.size());
		
		q.offer(9);
		System.out.println("Peek: " + q.peek() + " | Size = " + q.size());
		
		q.offer(8);
		System.out.println("Peek: " + q.peek() + " | Size = " + q.size());
		
		polledElmt = q.poll();		// pop / remove
		System.out.println("Polled Element: " + polledElmt + " | Size = " + q.size());
		System.out.println("Peek: " + q.peek() + " | Size = " + q.size());


	}
}