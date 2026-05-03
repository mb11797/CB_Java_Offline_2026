import java.util.Scanner;

public class NthRootOfNumberPrecised{

	public static double multiply(double a, int b){
        double ans = 1;
        for(int i=0; i<b; i++){
            ans = ans * a;
        }
        
        return ans;
    }

	public static double nthRootOfNumber(double no, int n){
		double low = 1.0;
		double high = no;
		double delta = 0.0000000001;

		while(high - low > delta){
			double mid = (low + high) / 2.0;
			// System.out.println("Low = " + low + " | High = " + high + " | Mid = " + mid + " | Diff = " + (high - low));

			double mid_power_n = multiply(mid, n);

			if(mid_power_n < no){
				low = mid;
			}
			else{
				high = mid;
			}
		}

		return low;
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		double m = scanner.nextDouble();

		System.out.print(n + "th Root of " + m + " = ");
		System.out.printf("%.8f\n", nthRootOfNumber(m, n));
	}
}

