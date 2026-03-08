public class MaximumSubarraySumUsingKadanesAlgorithm{
	public static int maxSubarraySumUsingKadanes(int[] arr){
		int maxSoFar = Integer.MIN_VALUE;
		int maxEndingHere = Integer.MIN_VALUE;

		for(int i=0; i<arr.length; i++){
			maxEndingHere = Math.max(maxEndingHere + arr[i], arr[i]);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}

		return maxSoFar;
	}

	public static void main(String[] args){
		int[] arr = {3,-2,1,-6,5};
		System.out.println("Max Subarray Sum using PrefixSum: " + maxSubarraySumUsingKadanes(arr));
	}
}