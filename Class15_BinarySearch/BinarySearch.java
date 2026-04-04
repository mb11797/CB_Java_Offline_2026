import java.util.Scanner;

public class BinarySearch{
	public static int binarySearch(int[] arr, int key){
		int n = arr.length;
		int low = 0;
		int high = n-1;

		while(low <= high){
			int mid = (low + high) / 2;

			if(arr[mid] == key){
				return mid;
			}
			else if(arr[mid] < key){
				low = mid + 1;
			}
			else{
				high = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		int[] arr = {2,5,8,13,17,19,32,37,45};		// Sorted
		int key = scanner.nextInt();

		int foundAtIdx = binarySearch(arr, key);
		System.out.println(key + " found at idx = " + foundAtIdx);

	}
}