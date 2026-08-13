import java.util.*;

public class ClimbingStairs{
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

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();

		System.out.println("No of Ways to reach Top = " + climbingStairsWays(n, k));
	}
}