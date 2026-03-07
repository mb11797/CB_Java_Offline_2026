public class PrefixSum{

	public static int[] generatePrefixSumArray(int[] arr){
		int n = arr.length;
		int[] prefixSum = new int[n];

		prefixSum[0] = arr[0];
		for(int i=1; i<n; i++){
			prefixSum[i] = prefixSum[i-1] + arr[i];
		}

		return prefixSum;
	}

	public static void main(String[] args){
		int[] arr = {3,2,1,6,5};
		int n = arr.length;

		int[] prefixSum = generatePrefixSumArray(arr);

		for(int i=0; i<n; i++){
			System.out.print(arr[i] + "\t");	// 1 tab = 8 spaces
		}
		System.out.println();

		for(int i=0; i<n; i++){
			System.out.print(prefixSum[i] + "\t");	// 1 tab = 8 spaces
		}
		System.out.println();
	}
}







