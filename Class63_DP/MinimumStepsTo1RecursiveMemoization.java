import java.util.*;

public class MinimumStepsTo1RecursiveMemoization{

	public static int minStepsTo1Rec(int n){
		if(n == 1){
			return 0;
		}
		int minSteps = Integer.MAX_VALUE;
		if(n % 3 == 0){
			int option1Steps = minStepsTo1Rec(n/3);
			minSteps = Math.min(minSteps, option1Steps);
		}

		if(n % 2 == 0){
			int option2Steps = minStepsTo1Rec(n/2);
			minSteps = Math.min(minSteps, option2Steps);
		}

		int option3Steps = minStepsTo1Rec(n-1);
		minSteps = Math.min(minSteps, option3Steps);

		return minSteps + 1;
	}

	public static int minStepsTo1Rec_Memoization(int n, int[] memo){
		if(n == 1){
			return 0;
		}

		// lookup  - check in dp or memo array
		if(memo[n] != -1){
			return memo[n];
		}


		int minSteps = Integer.MAX_VALUE;
		if(n % 3 == 0){
			int option1Steps = minStepsTo1Rec_Memoization(n/3, memo);
			minSteps = Math.min(minSteps, option1Steps);
		}

		if(n % 2 == 0){
			int option2Steps = minStepsTo1Rec_Memoization(n/2, memo);
			minSteps = Math.min(minSteps, option2Steps);
		}

		int option3Steps = minStepsTo1Rec_Memoization(n-1, memo);
		minSteps = Math.min(minSteps, option3Steps);

		return memo[n] = minSteps + 1;
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		int[] memo = new int[n+1]; 		// dp
		Arrays.fill(memo, -1);

		System.out.println("Minimum steps (n to 1): " + minStepsTo1Rec_Memoization(n, memo));
	}
}