import java.util.Scanner;

/*

Diamond:


 

 

*/

public class Diamond{

	public static void equilateralTriangle(int n){	
		for(int line=1; line<=n; line++){
			// Print (n-line) spaces
			for(int space=1; space<=n-line; space++)
				System.out.print(" ");
						
			// Print line no of stars
			for(int star=1; star<=line; star++){
				System.out.print("* ");
			}

			// Print new line
			System.out.println();
		}
	}

	public static void flippedEquilateralTriangle(int n){
		for(int line=1; line<=n; line++){
			// System.out.print(" ");

			// Print (line-1) spaces
			for(int space=1; space<=(line-1); space++)
				System.out.print(" ");

			// Print n-line+1 no of stars
			for(int star=1; star<=n-line+1; star++){
				System.out.print(" *");
			}

			// Print new line
			System.out.println();
		}
	}

	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		// n = 5

		equilateralTriangle(n); 						// -> n = 5
		flippedEquilateralTriangle(n-1);		// -> N = n-1 = 4


	}
}


