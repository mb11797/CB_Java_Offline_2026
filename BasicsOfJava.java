
public class BasicsOfJava{
	public static void main(String[] args){
		/*
		boolean userPayStatus = false;
		if(userPayStatus == false){
			System.out.println("Please pay your amount");
		}
		*/

		int amount = 87;

		if(amount < 50){
			System.out.println("Please pay your amount = 10");
		}
		else if(amount < 75){
			// for amount between 50 and 74 (both inclusive)
			System.out.println("Please pay your amount = 50");		
		}
		else{
			// for all amounts above 75 (inclusive)
			System.out.println("Please pay your amount = 75");
		}

		// Comment - Non-executable code
		// 2 Types: // some text or /* some text */
		// System.out.println();

		// Loops:
		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		System.out.println(4);
		System.out.println(5);

		// Print all numbers from 1 to 100
		// Manually - x
		// Use loops

		int i = 1;			// scope till main function
		while(i <= 100){
			System.out.println(i);
			i = i + 1;		// i++
		}
		// i = 101

		i = 1;
		do{
			System.out.println(i);
			i++;
		}
		while(i <= 100);

		for(i=0; i<=100; i++){
			System.out.println(i);			
		}



	}
}















