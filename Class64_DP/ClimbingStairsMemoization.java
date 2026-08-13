import java.util.*;

public class ClimbingStairsMemoization{
	public static int climbingStairsWays(int n, int k){
		if(n == 0){
			return 1;
		}

		int ans = 0;
		for(int i=1; i<=k; i++){
			if(n - i >= 0)
				ans += climbingStairsWays(n-i, k);
		}

		return ans;
	}

	public static int climbingStairsWaysMemoization(int n, int k, int[] memo){
		if(n == 0){
			return 1;
		}

		// lookup
		if(memo[n] != -1){
			return memo[n];
		}

		int ans = 0;
		for(int i=1; i<=k; i++){
			if(n - i >= 0)
				ans += climbingStairsWaysMemoization(n-i, k, memo);
		}

		return memo[n] = ans;
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int[] memo = new int[n+1];
		Arrays.fill(memo, -1);

		System.out.println("No of Ways to reach Top = " 
			+ climbingStairsWaysMemoization(n, k, memo));
	}
}