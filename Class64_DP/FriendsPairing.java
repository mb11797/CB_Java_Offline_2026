import java.util.*;

public class FriendsPairing{

	
	public static int friendsPairingRec(int n){
		if(n == 0){
			return 1;
		}

		if(n < 0){
			return 0;
		}

		return friendsPairingRec(n-1) + (n-1) * friendsPairingRec(n-2);
	}

	

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();


		System.out.println("No of Ways to seat" + n + " person on Bikes: " + friendsPairingRec(n));
	}
}





