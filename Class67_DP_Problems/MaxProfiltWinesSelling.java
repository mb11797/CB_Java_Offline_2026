import java.util.*;

public class MaxProfiltWinesSelling{

	public static int maxProfit(int[] price, int beg, int end, int year){
		if(beg > end){
			return 0;
		}

		int sellFromBeg = price[beg] * year + maxProfit(price, beg+1, end, year+1);
		int sellFromEnd = price[end] * year + maxProfit(price, beg, end-1, year+1);

		return Math.max(sellFromBeg, sellFromEnd);
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int nBottles = scanner.nextInt();

		int[] price = new int[nBottles];
		for(int i=0; i<nBottles; i++){
			price[i] = scanner.nextInt();
		}

		int year = 1;
		int n = price.length;
		System.out.println("Maximum Profit = " + maxProfit(price, 0, n-1, year));
	}
}