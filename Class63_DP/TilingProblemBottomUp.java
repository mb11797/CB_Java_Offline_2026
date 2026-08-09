import java.util.*;

public class TilingProblemBottomUp{

	
	public static int tilingWays(int n){
		if(n == 0){
			return 1;
		}

		if(n < 0)
			return 0;

		return tilingWays(n-1) + tilingWays(n-4);
	}

	public static int tilingWays_Memoization(int n, int[] memo){
		if(n == 0){
			return 1;
		}

		if(n < 0)
			return 0;

		// lookup in dp
		if(memo[n] != -1){
			return memo[n];
		}

		return memo[n] = tilingWays_Memoization(n-1, memo) + tilingWays_Memoization(n-4, memo);
	}

	public static int tilingWays_BottomUp(int n){
		int[] dp = new int[n+1];
		dp[0] = 1;

		for(int i=1; i<=n; i++){
			dp[i] = dp[i-1];
			if(i-4 >= 0){
				dp[i] += dp[i-4];
			}
		}
		return dp[n];
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();


		System.out.println("No of Ways to tile a 4 x " + n + " Floor = " + tilingWays_BottomUp(n));
	}
}





