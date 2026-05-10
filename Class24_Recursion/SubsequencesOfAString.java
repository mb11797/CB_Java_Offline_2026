import java.util.Scanner;

public class SubsequencesOfAString{


	public static void printIthSubsequence(String str, int idx){
		int len = str.length();
		StringBuilder sb = new StringBuilder();
		while(len > 0){
			if((idx & 1) == 1){
				sb.insert(0, str.charAt(len-1));
			}
			len--;
			idx = idx>>1;
		}

		System.out.println(sb.toString());
		return;
	}

	public static void printSubsequences(String str){
		int n = str.length();

		int totalSubsequences = 1 << n;			// n = 3 -> 2^3 = 8

		for(int i=0; i<totalSubsequences; i++){
			printIthSubsequence(str, i);
		}

		return;
	}


	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();

		printSubsequences(str);
	}

}