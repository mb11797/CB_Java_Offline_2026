import java.util.Scanner;

public class Factorial{
	
	
	public static int factorial(int n){
		if(n == 1 || n == 0)
			return 1;
		return n * factorial(n-1);
	}
	
	/*
	public static int factorial(int n){
		return n == 0 ? 1 : n * factorial(n-1);
	}
	*/
	

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		System.out.println(factorial(n));
	}
}