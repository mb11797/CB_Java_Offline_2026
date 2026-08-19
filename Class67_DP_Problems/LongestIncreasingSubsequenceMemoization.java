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

	public static int lisMemoization(int[] arr, int curIdx, int prevIdx, int[][] memo){
		if(curIdx == arr.length)
			return 0;

		if(memo[curIdx][prevIdx+1] != -1){
			return memo[curIdx][prevIdx+1];
		}

		// 2 Options -> exclude or include

		int excludeAns = lisMemoization(arr, curIdx+1, prevIdx, memo);

		int includeAns = Integer.MIN_VALUE;
		if(prevIdx < 0 || arr[curIdx] > arr[prevIdx]){
			includeAns = 1 + lisMemoization(arr, curIdx+1, curIdx, memo);
		}

		return memo[curIdx][prevIdx+1] = Math.max(excludeAns, includeAns);
	}

	public static int lis(int[] arr){
		int n = arr.length;
		
		int[][] memo = new int[n+1][n+1];
		for(int[] row: memo)
			Arrays.fill(row, -1);

		return lisMemoization(arr, 0, -1, memo);
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