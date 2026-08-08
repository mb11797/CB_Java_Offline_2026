import java.util.*;

public class Fibonacci{
	public static int counter;

	public static int fibonacci(int n){
		if(n == 1 || n == 0){
			return n;
		}
		// counter++;
		// System.out.println("fib(" + n + ") -> " + counter);
		return fibonacci(n-1) + fibonacci(n-2);
	}

	public static int fibonacciWithMemoization(int n, int[] memo){
		if(n == 1 || n == 0){
			return n;
		}

		if(memo[n] != -1){
			return memo[n];
		}

		// counter++;
		// System.out.println("fib(" + n + ") -> " + counter);
		int ans = fibonacciWithMemoization(n-1, memo) + fibonacciWithMemoization(n-2, memo);
		return memo[n] = ans;		// Memoization of the result in memo[] array
	}

	public static int fibonacciUsingBottomUpDP(int n){
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;

		for(int i=2; i<=n; i++){
			dp[i] = dp[i-1] + dp[i-2];
		}

		return dp[n];
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		// counter = 1;
		// int ans1 = fibonacci(n);
		// System.out.println(ans1);

		// n = 500 (maximum)
		// int[] memo = new int[100000];
		// Arrays.fill(memo, -1);

		// counter = 1;
		// int ans2 = fibonacciWithMemoization(n, memo);
		// System.out.println(ans2);


		// counter = 1;
		// int ans3 = fibonacciWithMemoization(n+5, memo);
		// System.out.println(ans3);

		int ans4 = fibonacciUsingBottomUpDP(n);
		System.out.println(ans4);
	}
}





