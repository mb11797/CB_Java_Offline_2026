import java.util.Scanner;
/*

Flipped Hollow Equilateral Triangle: 

* * * * *   l = 5 -> space = 0 
 *     *    l = 4 -> space = 5 = 6 - 1 = 2(4-1) - 1
  *   *     l = 3 -> space = 3
   * *      l = 2 -> space = 1
    *       l = 1 -> space = 0

*/

import java.util.Scanner;

public class FlippedHollowEquilateralTriangle{
  public static void main(String[] args){

    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    
    for(int line=n; line>=1; line--){
        // line = n,n-1, ..., 3,2,1
        for(int space=1; space<=n-line; space++){
            System.out.print(" ");
        }

        if(line == 1 || line == n){
            // line = n,1
            for(int star=1; star<=line; star++){
                System.out.print("* ");
            }
        }
        else{
            // line = n-1,n-2, ..., 3,2
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











