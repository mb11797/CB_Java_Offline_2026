import java.util.*;

public class FriendsPairingMemoization{

	
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

	

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] memo = new int[n+1];
		Arrays.fill(memo, -1);

		System.out.println("No of Ways to seat" + n + " person on Bikes: " 
			+ friendsPairingRecMemoization(n, memo));
	}
}





