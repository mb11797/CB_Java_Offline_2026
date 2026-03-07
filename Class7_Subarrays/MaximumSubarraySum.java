public class MaximumSubarraySum{

	public static int maxmimumSubarraySum(int[] arr){
		int n = arr.length;
		int maximumSubarraySum = Integer.MIN_VALUE;
		for(int i=0; i<n; i++){
			for(int j=i; j<n; j++){
				// i, j
				int subarraySum = 0;
				for(int k=i; k<=j; k++){
					subarraySum += arr[k];
				}

				if(subarraySum > maximumSubarraySum){
					maximumSubarraySum = subarraySum;
				}
				
			}
		}
		return maximumSubarraySum;
	}

	public static int maxmimumSubarraysSumOptimized(int[] arr){
		int n = arr.length;
		int maximumSubarraySum = Integer.MIN_VALUE;
		for(int i=0; i<n; i++){
			int subarraySum = 0;
			for(int j=i; j<n; j++){
				// i, j
				subarraySum += arr[j];
				
				if(subarraySum > maximumSubarraySum){
					maximumSubarraySum = subarraySum;
				}
			}
		}
		return maximumSubarraySum;
	}

	public static int maxmimumSubarraysSumUsingPrefixSum(int[] arr){
		int n = arr.length;
		int[] prefixSum = new int[n];

		prefixSum[0] = arr[0];
		for(int i=1; i<n; i++)
			prefixSum[i] = prefixSum[i-1] + arr[i];

		int maximumSubarraySum = Integer.MIN_VALUE;
		for(int i=0; i<n; i++){
			for(int j=i; j<n; j++){
				// i, j
				
				int subarraySum_i_to_j = prefixSum[j] - (i > 0 ? prefixSum[i-1] : 0);
				
				if(subarraySum_i_to_j > maximumSubarraySum){
					maximumSubarraySum = subarraySum_i_to_j;
				}
			}
		}
		return maximumSubarraySum;
	}

	public static void main(String[] args){
		int[] arr = {3,-2,1,-6,5};

		System.out.println("Max Subarray Sum: " + maxmimumSubarraySum(arr));
		System.out.println("Max Subarray Sum Optimized Way: " + maxmimumSubarraysSumOptimized(arr));
		System.out.println("Max Subarray Sum using PrefixSum: " + maxmimumSubarraysSumUsingPrefixSum(arr));
	}
}