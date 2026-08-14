import java.util.*;

public class CoinChange{
	
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

		long minCoinsForChange = coinChange(amount, coins);
		if(minCoinsForChange >= Integer.MAX_VALUE){
			System.out.println("Coin Change not possible with current Currency Denominations...");
			return;
		}
		System.out.println("Minimum no of Coins for Change of " + amount + " = " + minCoinsForChange);
		return;
	}
}





