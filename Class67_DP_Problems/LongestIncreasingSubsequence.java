import java.util.*;

public class LongestIncreasingSubsequence{

	public static int lis(int[] arr, int curIdx, int prevIdx){
		if(curIdx == arr.length)
			return 0;

		// 2 Options -> exclude or include

		int excludeAns = lis(arr, curIdx+1, prevIdx);

		int includeAns = Integer.MIN_VALUE;
		if(prevIdx < 0 || arr[curIdx] > arr[prevIdx]){
			includeAns = 1 + lis(arr, curIdx+1, curIdx);
		}

		return Math.max(excludeAns, includeAns);
	}

	public static int lis(int[] arr){
		return lis(arr, 0, -1);
	}
	

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter no of Elements: ");
		int n = scanner.nextInt();

		System.out.println("Enter Array Elements: ");
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = scanner.nextInt();
		}

		System.out.println("Length of Longest Increasing Subsequence = " + lis(arr));		
	}
}