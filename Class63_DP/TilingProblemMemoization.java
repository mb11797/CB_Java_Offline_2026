import java.util.*;

public class TilingProblemMemoization{

	
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


	

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		int[] memo = new int[n+1];
		Arrays.fill(memo, -1);

		System.out.println("No of Ways to tile a 4 x " + n + " Floor = " + tilingWays_Memoization(n, memo));
	}
}





