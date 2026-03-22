import java.util.Scanner;

public class BubbleSort{

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

	public static void bubbleSort(int[] arr){
		int n = arr.length;
		for(int i=0; i<n; i++){
			for(int j=0; j<n-i-1; j++){
				if(arr[j] > arr[j+1]){
					swap(arr, j, j+1);
				}
			}
		}
	}

	public static void bubbleSort(int[] arr, boolean isDesc){
		int n = arr.length;
		for(int i=0; i<n; i++){
			for(int j=0; j<n-i-1; j++){
				if(isDesc){
					if(arr[j] < arr[j+1]){
						swap(arr, j, j+1);
					}
				}
				else{
					if(arr[j] > arr[j+1]){
						swap(arr, j, j+1);
					}
				}
			}
		}
	}


	public static void main(String[] args){
		int[] arr = inputArray();

		printArr(arr);
		// bubbleSort(arr);
		bubbleSort(arr, true);
		printArr(arr);

	}

}