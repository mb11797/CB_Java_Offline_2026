import java.util.Scanner;

/*
Inverted Mirrored Half Pyramid 

* * * * *  
  * * * * 
    * * * 
      * * 
        * 
*/

public class InvertedMirroredHalfPyramid{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();

		for(int l=1; l<=n; l++){
			// TODO: l-1 spaces -> variable -> use loop
			for(int space=1; space<=l-1; space++){
				System.out.print(" ");
			}

			// TODO: n-l+1 stars -> variable -> use loop
			for(int star=1; star<=n-l+1; star++){
				System.out.print("*");
			}

			// TODO: 1 new line
			System.out.println();
		}


	}
}