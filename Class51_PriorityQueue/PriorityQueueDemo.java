import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Comparator;

public class PriorityQueueDemo{

	public static class DescOrderComparator implements Comparator<Integer>{
		@Override
		public int compare(Integer a, Integer b){
			return b - a;
		}
	}

	public static class SquareBasedDescComparator implements Comparator<Integer>{
		@Override
		public int compare(Integer a, Integer b){
			// return b*b - a*a;
			return Integer.compare(b*b, a*a);
		}
	}

	public static class SquareBasedAscComparator implements Comparator<Integer>{
		@Override
		public int compare(Integer a, Integer b){
			return a*a - b*b;
		}
	}

	public static void main(String[] args){
		PriorityQueue<Integer> minPQ = new PriorityQueue<>();
		minPQ.offer(4);
		minPQ.offer(1);
		minPQ.offer(3);
		minPQ.offer(2);
		
		System.out.println("Min-Heap Elements: ");
		while(!minPQ.isEmpty()){
			int poppedElmt = minPQ.peek();
			minPQ.poll();

			System.out.print(poppedElmt + " ");
		}
		System.out.println();

		// PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());	
		PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a,b) -> b - a);				// Lambda Expression
		// PriorityQueue<Integer> maxPQ = new PriorityQueue<>(new DescOrderComparator());	

		maxPQ.offer(4);
		maxPQ.offer(1);
		maxPQ.offer(3);
		maxPQ.offer(2);
			
		System.out.println("Max-Heap Elements: ");
		while(!maxPQ.isEmpty()){
			int poppedElmt = maxPQ.poll();
			System.out.print(poppedElmt + " ");
		}
		System.out.println();

		PriorityQueue<Integer> myDescPQ = new PriorityQueue<>(new SquareBasedDescComparator());	

		myDescPQ.offer(-8);
		myDescPQ.offer(-2);
		myDescPQ.offer(3);
		myDescPQ.offer(-4);

		System.out.println("Square Based Desc Heap Elements: ");
		while(!myDescPQ.isEmpty()){
			int poppedElmt = myDescPQ.poll();
			System.out.print(poppedElmt + " ");
		}
		System.out.println();

		PriorityQueue<Integer> myAscPQ = new PriorityQueue<>(new SquareBasedAscComparator());	

		myAscPQ.offer(-8);
		myAscPQ.offer(-2);
		myAscPQ.offer(3);
		myAscPQ.offer(-4);

		System.out.println("Square Based Asc Heap Elements: ");
		while(!myAscPQ.isEmpty()){
			int poppedElmt = myAscPQ.poll();
			System.out.print(poppedElmt + " ");
		}
		System.out.println();

		return;
	}

}