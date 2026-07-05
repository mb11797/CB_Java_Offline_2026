import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElementRight{

	public static int[] nextGreaterElementToTheRight(int[] arr){
		int n = arr.length;
		int[] ngeRight = new int[n];

		Stack<Integer> stk = new Stack<>();		// indices

		for(int i=0; i<n; i++){
			// Work 1: 
			while(!stk.isEmpty() && arr[i] > arr[stk.peek()]){
				ngeRight[stk.pop()] = arr[i];
			}

			// Work 2:
			stk.push(i);
		}

		while(!stk.isEmpty()){
			ngeRight[stk.pop()] = -1;
		}

		return ngeRight;
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
		int[] ngeRight = nextGreaterElementToTheRight(arr);	
		printArr(ngeRight);
	}
}