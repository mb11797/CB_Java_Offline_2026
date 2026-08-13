import java.util.*;

public class FriendsPairingBottomUpDP{

	
	public static int friendsPairingRec(int n){
		if(n == 0){
			return 1;
		}

		if(n < 0){
			return 0;
		}

		return friendsPairingRec(n-1) + (n-1) * friendsPairingRec(n-2);
	}

	public static int friendsPairingRecMemoization(int n, int[] memo){
		if(n == 0){
			return 1;
		}

		if(n < 0){
			return 0;
		}

		if(memo[n] != -1){
			return memo[n];
		}

		return memo[n] = friendsPairingRecMemoization(n-1, memo) 
						+ (n-1) * friendsPairingRecMemoization(n-2, memo);
	}

	public static int friendsPairingBottomUpDP(int n){
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i=2; i<=n; i++){
			dp[i] = dp[i-1] + (i-1) * dp[i-2];
		}

		return dp[n];
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		System.out.println("No of Ways to seat" + n + " person on Bikes: " 
			+ friendsPairingBottomUpDP(n));
	}
}





