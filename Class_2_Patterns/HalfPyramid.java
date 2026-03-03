import java.util.Scanner;

/*
	Half Pyramid 

	*  
	* * 
	* * * 
	* * * * 
	* * * * * 

*/

public class HalfPyramid{
	public static void main(String[] args){

		// System.out.println("*");
		// System.out.println("**");
		// System.out.println("***");
		// System.out.println("****");
		// System.out.println("*****");

		// Way 1
		// Scanner myInputGetter = new Scanner(System.in);	// Declaration + Initialization

		// Way 2
		Scanner myInputGetter;	// Declaration
		myInputGetter = new Scanner(System.in);		// Initialization

		int n = myInputGetter.nextInt();

		for(int line=1; line <= n; ++line){
			// 
			for(int star=1; star <= line; star++){	// to print stars of a particular line
				System.out.print("*");
			}		
			System.out.println();
		}
	}
}














