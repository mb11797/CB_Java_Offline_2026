import java.util.Scanner;

/*

Equilateral Triangle 

          *    
        *   * 
      *   *   * 
    *   *   *   * 
  *   *   *   *   * 


*/

public class EquilateralTriangle{
	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		for(int line=1; line<=n; line++){
			// Print (n-line) spaces
			for(int space=1; space<=n-line; space++)
				System.out.print(" ");
						
			/*
			if(some condition)
				for(int i=0; i<n; i++)
					System.out.print("* ");
			else
				System.out.print(" ");
			*/

			// Print line no of stars
			for(int star=1; star<=line; star++){
				System.out.print("* ");
			}

			// Print new line
			System.out.println();
		}
	}
}


