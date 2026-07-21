public class PriorityQueueClient{
	public static void main(String[] args){
		PriorityQueue minPQ = new PriorityQueue(true);

		System.out.println("Top Element: " + minPQ.top());
		System.out.println("Size: " + minPQ.size());
		System.out.println("isEmpty: " + minPQ.isEmpty());

		minPQ.push(444);
		minPQ.push(123);
		minPQ.push(3);
		minPQ.push(22);
		minPQ.push(78);
		minPQ.push(6);
		minPQ.push(2);
		minPQ.push(39);

		System.out.println("Top Element: " + minPQ.top());
		System.out.println("Size: " + minPQ.size());
		System.out.println("isEmpty: " + minPQ.isEmpty());

		while(!minPQ.isEmpty()){
			int poppedEl = minPQ.pop();
			System.out.println(poppedEl + " ");
		}
		System.out.println();

		System.out.println("Top Element: " + minPQ.top());
		System.out.println("Size: " + minPQ.size());
		System.out.println("isEmpty: " + minPQ.isEmpty());
	}
}