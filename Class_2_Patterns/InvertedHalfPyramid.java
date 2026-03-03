import java.util.Scanner;

/*
Inverted Half Pyramid 

* * * * *  

* * * * 

* * * 

* * 

* 

*/

public class InvertedHalfPyramid{
	public static void main(String[] args){

		Scanner myInputGetter;	// Declaration
		myInputGetter = new Scanner(System.in);		// Initialization

		int n = myInputGetter.nextInt();

		for(int l=1; l<=n; l++){
			for(int star=1; star <= n-l+1; star++){
				System.out.print("*");
			}
			// Method - 2
			// for(int star = n; star >= l; star--){
			// 	System.out.print("*");
			// }

			System.out.println();
		}

	}
}














