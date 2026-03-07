public class BreakAndContinue{
	public static void main(String[] args){
		// break
		for(int i=0; i<10; i++){
			if(i == 6){
				break;
			}
			System.out.print(i + " ");
		}
		System.out.println();
		// Output: 0 1 2 3 4 5


		for(int i=0; i<5; i++){
			for(int j=i+1; j<5; j++){
				if(j == 3){
					break;
				}
				System.out.print(i + ", " + j + " -> ");
			}
			System.out.println();
		}
		// Output: 
		// 0,1 -> 0,2 -> 
		// 1,2 -> 

		// 3,4


		// continue
		for(int i=0; i<10; i++){
			if(i == 6){
				continue;
			}
			System.out.print(i + " ");
		}
		System.out.println();
		// Output: 0 1 2 3 4 5 7 8 9 

		for(int i=0; i<5; i++){
			for(int j=i+1; j<5; j++){
				if(j == 3){
					continue;
				}
				System.out.print(i + ", " + j + " -> ");
			}
			System.out.println();
		}
	}
}