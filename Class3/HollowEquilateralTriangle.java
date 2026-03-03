import java.util.Scanner;

/*

Hollow Equilateral Triangle: 
 

    *       l = 1
   * *      l = 2
  *   *     l = 3
 *     *    l = 4
* * * * *   l = 5

*/

public class HollowEquilateralTriangle{
  public static void main(String[] args){

    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    
    for(int line=1; line<=n; line++){
    	// line = 1,2,3,4,5, ..., n
    	for(int space=1; space<=n-line; space++){
    		System.out.print(" ");
    	}

    	if(line == 1 || line == n){
    		// line = 1,n
    		for(int star=1; star<=line; star++){
    			System.out.print("* ");
    		}
    	}
    	else{
    		// line = 2,3,4,...n-1
    		System.out.print("*");

			for(int space=1; space<=2*line-3; space++){
				System.out.print(" ");
			}

    		System.out.print("*");
    	}
		System.out.println();
    }
  }
}











