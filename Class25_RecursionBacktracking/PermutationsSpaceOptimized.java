import java.util.Scanner;



public class PermutationsSpaceOptimized{


	public static void swap(char[] chArr, int i, int j){
		char temp = chArr[i];
		chArr[i] = chArr[j];
		chArr[j] = temp;

		return;
	}

	public static void print(char[] chArr){
		for(int k=0; k<chArr.length; k++){
				System.out.print(chArr[k]);
			}
		System.out.println();
	}

	public static void permute(char[] chArr, int i){
		if(i == chArr.length){
			// System.out.println(String.valueOf(chArr));		// creates new memory
			print(chArr);
			return;
		}

		for(int j=i; j<chArr.length; j++){
			swap(chArr, i, j);
			permute(chArr, i+1);
			swap(chArr, i, j);			// Backtracking
		}
	}

	public static void permute(String str){
		char[] chArr = str.toCharArray();
		System.out.print("Before: ");
		print(chArr);

		permute(chArr, 0);

		System.out.print("After: ");
		print(chArr);
	}

	public static void main(String[] artgs){
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();

		System.out.println("All Permutations of " + str + " are: ");
		permute(str);
	}
}