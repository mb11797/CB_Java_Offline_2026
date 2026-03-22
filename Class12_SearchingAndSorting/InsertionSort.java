import java.util.Scanner;

public class InsertionSort{

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

	public static void insertionSort(int[] arr){
		int n = arr.length;
		for(int i=0; i<n; i++){
			// ith element - starting element of unsorted region
			int j=i-1;		// sorted region -> 0 to i-1
			int no = arr[i];

			while(j >= 0 && arr[j] > no){
				arr[j+1] = arr[j];		// shift jth element to the right by 1
				arr[j] = -1;
				j--;
			}

			arr[j+1] = no;
		}
	}

	public static void main(String[] args){
		int[] arr = inputArray();

		printArr(arr);
		insertionSort(arr);
		printArr(arr);

	}

}