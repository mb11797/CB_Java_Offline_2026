import java.util.Scanner;
import java.util.Stack;

public class NextSmallerElementLeft{

	public static int[] nextSmallerElementToTheLeft(int[] arr){
		int n = arr.length;
		int[] nseLeft = new int[n];

		Stack<Integer> stk = new Stack<>();		// indices

		for(int i=n-1; i>=0; i--){
			// Work 1: 
			while(!stk.isEmpty() && arr[i] < arr[stk.peek()]){
				nseLeft[stk.pop()] = arr[i];
			}

			// Work 2:
			stk.push(i);
		}

		while(!stk.isEmpty()){
			nseLeft[stk.pop()] = -1;
		}

		return nseLeft;
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
		int[] nseLeft = nextSmallerElementToTheLeft(arr);	
		printArr(nseLeft);
	}
}