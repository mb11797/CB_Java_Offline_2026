import java.util.*;

public class CoinChangeBottomUpDP{
	
	public static long coinChange(int n, int[] coins){
		if(n == 0){
			return 0;
		}

		long ans = Integer.MAX_VALUE;
		for(int i=0; i<coins.length; i++){
			if(n - coins[i] >= 0)
				ans = Math.min(ans, coinChange(n - coins[i], coins));
		}

		return 1 + ans;
	}

	public static long coinChangeMemoization(int n, int[] coins, long[] memo){
		if(n == 0){
			return 0;
		}

		// lookup
		if(memo[n] != -1)
			return memo[n];

		long ans = Integer.MAX_VALUE;
		for(int i=0; i<coins.length; i++){
			if(n - coins[i] >= 0)
				ans = Math.min(ans, coinChangeMemoization(n - coins[i], coins, memo));
		}

		return memo[n] = 1 + ans;
	}

	public static long coinChangeBottomUpDP(int amount, int[] coins){
		long[] dp = new long[amount+1];
		dp[0] = 0;

		for(int i=1; i<=amount; i++){
			long ans = Integer.MAX_VALUE;
			for(int coin: coins){
				if(i - coin >= 0){
					ans = Math.min(ans, dp[i - coin]);
				}
			}
			dp[i] = ans + 1;
		}

		return dp[amount] >= Integer.MAX_VALUE ? -1 : dp[amount];
	}


	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter no of Coins: ");
		int nCoins = scanner.nextInt();

		System.out.println("Enter Coin Denominations: ");
		int[] coins = new int[nCoins];
		for(int i=0; i<nCoins; i++)
			coins[i] = scanner.nextInt();

		System.out.println("Enter amount for change: ");
		int amount = scanner.nextInt();

		long minCoinsForChange = coinChangeBottomUpDP(amount, coins);
		if(minCoinsForChange >= Integer.MAX_VALUE){
			System.out.println("Coin Change not possible with current Currency Denominations...");
			return;
		}
		System.out.println("Minimum no of Coins for Change of " + amount + " = " + minCoinsForChange);
		return;
	}
}





