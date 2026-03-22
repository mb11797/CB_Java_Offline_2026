import java.util.Scanner;

public class LinearSearch{

	public static int[] inputArray(){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[n];

		for(int i=0; i<n; i++){
			arr[i] = scanner.nextInt();
		}

		return arr;
	}

	public static int linearSearch(int[] arr, int key){
		arr = new int[n];
		
		for(int i=0; i<arr.length; i++){
			if(arr[i] == key){
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args){
		int[] arr = inputArray();

		Scanner scanner = new Scanner(System.in);
		int key = scanner.nextInt();

		int foundAtIdx = linearSearch(arr, key);

		System.out.println((foundAtIdx != -1 ? ("Found " + key + " at index = " + foundAtIdx) : (key + " not found")));
	}

}