import java.util.Scanner;

/*

Flipped Equilateral Triangle 

  *   *   *   *   * 
    *   *   *   * 
      *   *   * 
        *   * 
          * 

 

 

*/

public class FlippedEquilateralTriangle{
	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		for(int line=1; line<=n; line++){
			// Print (line-1) spaces
			for(int space=1; space<=(line-1); space++)
				System.out.print(" ");
						
			/*
			if(some condition)
				for(int i=0; i<n; i++)
					System.out.print("* ");
			else
				System.out.print(" ");
			*/

			// Print n-line+1 no of stars
			for(int star=1; star<=n-line+1; star++){
				System.out.print("* ");
			}

			// Print new line
			System.out.println();
		}
	}
}


