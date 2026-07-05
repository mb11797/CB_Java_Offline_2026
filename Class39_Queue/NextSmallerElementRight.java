import java.util.Scanner;
import java.util.Stack;

public class NextSmallerElementRight{

	public static int[] nextSmallerElementToTheRight(int[] arr){
		int n = arr.length;
		int[] nseRight = new int[n];

		Stack<Integer> stk = new Stack<>();		// indices

		for(int i=0; i<n; i++){
			// Work 1: 
			while(!stk.isEmpty() && arr[i] < arr[stk.peek()]){
				nseRight[stk.pop()] = arr[i];
			}

			// Work 2:
			stk.push(i);
		}

		while(!stk.isEmpty()){
			nseRight[stk.pop()] = -1;
		}

		return nseRight;
	}

	public static void printArr(int[] arr){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		return;
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = scanner.nextInt();
		}

		printArr(arr);
		int[] nseRight = nextSmallerElementToTheRight(arr);	
		printArr(nseRight);
	}
}