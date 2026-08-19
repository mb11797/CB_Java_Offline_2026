import java.util.*;

public class LongestIncreasingSubsequenceBottomUpDP{

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

	public static int lisBottomUpDP(int[] arr){
		int n = arr.length;
		int[] dp = new int[n];
		dp[0] = 1;

		int ans = dp[0];

		for(int i=1; i<n; i++){
			int maxm = 0;
			for(int j=0; j<i; j++){
				if(arr[i] > arr[j]){
					maxm = Math.max(maxm, dp[j]);
				}
			}

			dp[i] = maxm + 1;
			ans = Math.max(ans, dp[i]);
		}

		return ans;
	}

	public static int lis(int[] arr){
		return lisBottomUpDP(arr);
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