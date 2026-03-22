import java.util.Scanner;

public class SelectionSort{

	public static int[] inputArray(){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];

		for(int i=0; i<n; i++){
			arr[i] = scanner.nextInt();
		}

		return arr;
	}

	public static void printArr(int[] arr){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + " ");;
		}
		System.out.println();
	}

	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void selectionSort(int[] arr){
		int n = arr.length;

		for(int i=0; i<n; i++){
			int minIdx = i;		// Assumption current element in itself is minm
			for(int j=i+1; j<n; j++){
				if(arr[j] < arr[minIdx]){
					minIdx = j;
				}
			}

			swap(arr, i, minIdx);
		}
	}

	public static void selectionSortDescending(int[] arr){
		int n = arr.length;

		for(int i=0; i<n; i++){
			int maxIdx = i;		// Assumption current element in itself is maxm
			for(int j=i+1; j<n; j++){
				if(arr[j] > arr[maxIdx]){
					maxIdx = j;
				}
			}

			swap(arr, i, maxIdx);
		}
	}


	public static void main(String[] args){
		int[] arr = inputArray();

		printArr(arr);
		selectionSort(arr);
		// selectionSortDescending(arr);
		printArr(arr);
	}
}













