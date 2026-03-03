import java.util.Scanner;

public class ArrayOperations{

	public static void printArray(int[] arr){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void reversePrintArray(int[] arr){
		int n = arr.length;
		for(int i=n-1; i>=0; i--){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static int findLargestInArray(int[] arr){
		int maxm = arr[0];
		for(int i=1; i<arr.length; i++){
			if(arr[i] > maxm){
				maxm = arr[i];
			}
		}
		return maxm;
	}

	public static int findSmallestInArray(int[] arr){
		int minm = arr[0];
		for(int i=1; i<arr.length; i++){
			if(arr[i] < minm){
				minm = arr[i];
			}
		}
		return minm;
	}

	public static int findSecondLargestInArray(int[] arr){
		int maxm = arr[0];
		int secondMaxm = Integer.MIN_VALUE;

		for(int i=1; i<arr.length; i++){
			if(arr[i] > maxm){
				secondMaxm = maxm;
				maxm = arr[i];
			}
			else if(arr[i] > secondMaxm){
				secondMaxm = arr[i];
			}
		}
		return secondMaxm;
	}

	public static void main(String[] args){
		// Hard Coded Way
		/*
		int[] arr = new int[5];
		arr[0] = 3;
		arr[1] = 2;
		arr[2] = 1;
		arr[3] = 6;
		arr[4] = 5;

		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);

		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
		*/

		// User Input Array
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		int[] arr2 = new int[n];

		for(int i=0; i<n; i++){
			arr2[i] = scanner.nextInt();
		}

		printArray(arr2);
		reversePrintArray(arr2);

		System.out.println("Maximum in Array: " + findLargestInArray(arr2));
		System.out.println("Minimum in Array: " + findSmallestInArray(arr2));
		System.out.println("Second Maximum in Array: " + findSecondLargestInArray(arr2));
		
	}
}





