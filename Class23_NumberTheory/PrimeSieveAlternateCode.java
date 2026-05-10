import java.util.Scanner;

public class PrimeSieveAlternateCode{

	public static void generatePrimeSieve(boolean[] primeSieve){
		primeSieve[2] = true;

		// make all odd nos equal to true
		for(int i=3; i< primeSieve.length; i+=2){
			primeSieve[i] = true;
		}

		// make all multiples of prime nos equal to false
		for(int i=3; i< primeSieve.length; i+=2){
			if(primeSieve[i]){
				for(int j=2*i; j<primeSieve.length; j+=i){
					primeSieve[j] = false;
				}
			}
		}
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n;
		System.out.println("Enter n: ");
		n = scanner.nextInt();

		boolean[] primeSieve = new boolean[n+1];		// by default all values are prefilled with false
		// Arrays.fill(primeSieve, false);
		System.out.println("Generating Prime Sieve...");
		generatePrimeSieve(primeSieve);
		System.out.println("Prime Sieve Generated.");

		for(int i=1; i<=n; i++){
			if(primeSieve[i]){
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}
}