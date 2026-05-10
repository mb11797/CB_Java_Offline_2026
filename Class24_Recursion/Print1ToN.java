import java.util.Scanner;

public class Print1ToN{
	public static void print1ToN(int n){
		if(n == 0){
			return;
		}

		print1ToN(n-1);
		System.out.print(n + " ");
		return;
	}


	/*
	public static void print1ToN(int curr, int n){
		if(curr == n+1){
			return;
		}

		System.out.print(curr + " ");
		print1ToN(curr+1);
		return;
	}
	*/

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		print1ToN(1, n);
		// print1ToN(1, n);
		System.out.println();
	}
}