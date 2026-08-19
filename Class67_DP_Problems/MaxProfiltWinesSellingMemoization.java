import java.util.*;

public class MaxProfiltWinesSellingMemoization{

	public static int maxProfit(int[] price, int beg, int end, int year){
		if(beg > end){
			return 0;
		}

		int sellFromBeg = price[beg] * year + maxProfit(price, beg+1, end, year+1);
		int sellFromEnd = price[end] * year + maxProfit(price, beg, end-1, year+1);

		return Math.max(sellFromBeg, sellFromEnd);
	}

	public static int maxProfitMemoization(int[] price, int beg, int end, int year, int[][] memo){
		if(beg > end){
			return 0;
		}

		// lookup in memo table
		if(memo[beg][end] != -1)
			return memo[beg][end];

		int sellFromBeg = price[beg] * year + maxProfitMemoization(price, beg+1, end, year+1, memo);
		int sellFromEnd = price[end] * year + maxProfitMemoization(price, beg, end-1, year+1, memo);

		return memo[beg][end] = Math.max(sellFromBeg, sellFromEnd);
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter no of Wine Bottles on Shelf: ");
		int nBottles = scanner.nextInt();

		System.out.println("Enter Price of Wine Bottles: ");
		int[] price = new int[nBottles];
		for(int i=0; i<nBottles; i++){
			price[i] = scanner.nextInt();
		}

		int year = 1;
		int n = price.length;

		int[][] memo = new int[n][n];
		for(int[] row: memo)
			Arrays.fill(row, -1);

		System.out.println("Maximum Profit after Selling all Wines (Recursion) = " + maxProfit(price, 0, n-1, year));		
		System.out.println("Maximum Profit after Selling all Wines (Recursion + Memoization) = " + maxProfitMemoization(price, 0, n-1, year, memo));
	}
}