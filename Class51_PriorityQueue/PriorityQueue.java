import java.util.List;
import java.util.ArrayList;

public class PriorityQueue{

	private List<Integer> list;
	private boolean isMinHeap;

	public PriorityQueue(boolean minHeap){
		list = new ArrayList<>();
		list.add(-1);
		this.isMinHeap = minHeap;
	}

	private boolean compareToSwap(int child, int parent){
		if(this.isMinHeap){
			return parent > child;		// if parent > child -> return true -> means swap is required 
		}
		else{
			return parent < child;		// if parent < child -> return true -> means swap is required 
		}
	}

	private void swap(int i, int j){
		int temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}

	private void upHeapify(){
		int curIdx = list.size() - 1;
		int parentIdx = curIdx / 2;

		while(curIdx > 1 && compareToSwap(list.get(curIdx), list.get(parentIdx))){
			swap(curIdx, parentIdx);
			curIdx = parentIdx;
			parentIdx = curIdx / 2;
		}	
	}

	public void push(int el){
		list.add(el);		// add last in list

		upHeapify();
	}

	private void downHeapify(int idx){
		int leftChildIdx = 2*idx;
		int rightChildIdx = 2*idx+1;

		int minIdx = idx;
		if(leftChildIdx < list.size() && compareToSwap(list.get(leftChildIdx), list.get(minIdx))){
			minIdx = leftChildIdx;
		}

		if(rightChildIdx < list.size() && compareToSwap(list.get(rightChildIdx), list.get(minIdx))){
			minIdx = rightChildIdx;
		}

		if(minIdx != idx){
			swap(idx, minIdx);
			downHeapify(minIdx);
		}
	}

	public int pop(){
		if(isEmpty()){
			System.out.println("PriorityQueue is Empty...");
			return Integer.MIN_VALUE;
		}

		int poppedEl = list.get(1);

		// Step-1
		swap(1, list.size()-1);

		// Step-2
		list.remove(size());

		// Step-3
		downHeapify(1);

		return poppedEl;
	}

	public int top(){
		if(isEmpty()){
			System.out.println("PriorityQueue is Empty...");
			return Integer.MIN_VALUE;
		}
		return list.get(1);
	}

	public int size(){
		return list.size() - 1;
	}

	public boolean isEmpty(){
		return size() == 0;
	}

}