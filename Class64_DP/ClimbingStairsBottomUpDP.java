import java.util.*;

public class ClimbingStairsBottomUpDP{
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

	public static int climbingStairsWaysBottomUpDP(int n, int k){
		int[] dp = new int[n+1];
		dp[0] = 1;

		for(int i=1; i<=n; i++){
			dp[i] = 0;
			for(int j=1; j<=k; j++){
				if(i-j >= 0)
					dp[i] += dp[i-j];
			}
		}

		return dp[n];
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();

		System.out.println("No of Ways to reach Top = " 
			+ climbingStairsWaysBottomUpDP(n, k));
	}
}