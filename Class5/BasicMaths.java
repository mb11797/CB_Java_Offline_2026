import java.util.Scanner;

public class BasicMaths{

	public static int countDigits(int n){
		int count = 0;
		while(n > 0){
			n = n / 10;
			count++;
		}

		return count;
	}

	public static int reverseNo(int n){
		int reverseNo = 0;
		while(n > 0){
			int remainder = n % 10;
			reverseNo = reverseNo * 10 + remainder;
			n = n / 10;
		}
		return reverseNo;
	}

	public static boolean checkPalindrome(int n){
		if(n == reverseNo(n))
			return true;		
		else
			return false;
	}

	public static boolean isPrime(int n){
		int i = 2;
		while(i < n){
			if((n % i) == 0){
				return false;
			}
			i++;
		}
		return true;
	}

	public static void printFizzBuzz(int n){
		for(int i=1; i<=n; i++){
			if(i % 3 == 0 && i % 5 == 0)
				System.out.print("FizzBuzz ");
			else if(i % 3 == 0)
				System.out.print("Fizz ");
			else if(i % 5 == 0)
				System.out.print("Buzz ");
			else
				System.out.print(i + " ");
		}
	}

	public static int squareRoot(int n){
		int i=1;
		int possibleAns = 0; 
		while(find_iPowerN(i, 2) <= n){
			possibleAns = i;
			i++;
		}

		return possibleAns;		
	}

	public static int find_iPowerN(int i, int n){
		int ans = 1;
		for(int j=0; j<n; j++){
			ans = ans * i;
		}
		return ans;
	}

	public static int nthRoot(int no, int n){
		int i=1;
		int possibleAns = 0; 
		while(find_iPowerN(i, n) <= no){
			possibleAns = i;
			i++;
		}
		return possibleAns;		
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		// int noOfDigits = countDigits(n);
		// System.out.println("Count of Digits = " + noOfDigits);


		// System.out.println("Count of Digits = " + countDigits(n));
		// System.out.println("Reverse = " + reverseNo(n));
		
		// /*
		// if(checkPalindrome(n))
		// 	System.out.println("Palindrome No");
		// else
		// 	System.out.println("Not a Palindrome");
		// */

		// System.out.println(checkPalindrome(n) ? "Palindrome No" : "Not a Palindrome");
		// System.out.println(isPrime(n) ? "Prime No" : "Not Prime");

		// printFizzBuzz(n);
		// System.out.println();

		// System.out.println("Square Root: " + squareRoot(n));
		System.out.println("nth Root: " + nthRoot(n, 4));
		
		return;
	}
}

