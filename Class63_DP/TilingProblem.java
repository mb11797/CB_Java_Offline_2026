import java.util.*;

public class TilingProblem{

	
	public static int tilingWays(int n){
		if(n == 0){
			return 1;
		}

		if(n < 0)
			return 0;

		return tilingWays(n-1) + tilingWays(n-4);
	}

	public static int tilingWaysAlternate(int n){
		if(n == 0){
			return 1;
		}

		int ways = tilingWays(n-1);

		if(n-4 >= 0){
			ways += tilingWays(n-4);
		}

		return ways;
	}
	

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		System.out.println("No of Ways to tile a 4 x " + n + " Floor = " + tilingWays(n));
	}
}





