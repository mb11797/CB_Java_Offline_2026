import java.util.Scanner;

/*

Hollow Rectangle: 

* * * * *  
*       * 
*       * 
*       * 
* * * * * 
 
m x n

*/

public class HollowRectangle{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();

		for(int line=1; line<=n; line++){
			if(line == 1 || line == n){
				// line = 1,n
				for(int star=1; star<=m; star++){
					System.out.print("*");
				}
			}
			else{
				// line = 2,3,4,...,(n-1)
				// Print 1 star
				System.out.print("*");

				// Print (n-2)
				for(int space=1; space<=(m-2); space++){
					System.out.print(" ");
				}

				// Print 1 star
				System.out.print("*");
			}

			System.out.println();
		}
	}
}


