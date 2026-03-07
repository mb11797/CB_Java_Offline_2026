public class PrintAllSubarraysSum{

	public static void printAllSubarrays(int[] arr){
		int n = arr.length;
		// Print all subarrays
		for(int i=0; i<n; i++){
			for(int j=i; j<n; j++){
				// i, j
				for(int k=i; k<=j; k++){
					System.out.print(arr[k] + " ");
				}
				System.out.println();
			}
		}
		System.out.println();
	}

	public static void printAllSubarraysAndTheirSum(int[] arr){
		int n = arr.length;
		// Print all subarrays with their respective sum
		for(int i=0; i<n; i++){
			for(int j=i; j<n; j++){
				// i, j
				int subarraySum = 0;
				for(int k=i; k<=j; k++){
					System.out.print(arr[k] + " ");
					subarraySum += arr[k];
				}
				
				System.out.println("\t\t -> \t" + subarraySum);
			}
		}
		System.out.println();
	}

	public static void printAllSubarraysSum(int[] arr){
		int n = arr.length;
		// Print all subarrays with their respective sum
		for(int i=0; i<n; i++){
			for(int j=i; j<n; j++){
				// i, j
				int subarraySum = 0;
				for(int k=i; k<=j; k++){
					subarraySum += arr[k];
				}
				
				System.out.println(i + " -> " + j + " = " + subarraySum);
			}
		}
		System.out.println();
	}

	public static void printAllSubarraysSumOptimized(int[] arr){
		int n = arr.length;
		// Print all subarrays with their respective sum
		for(int i=0; i<n; i++){
			int subarraySum = 0;
			for(int j=i; j<n; j++){
				// i, j
				subarraySum += arr[j];
				
				System.out.println(i + " -> " + j + " = " + subarraySum);
			}
		}
		System.out.println();
	}

	public static void printAllSubarraysSumUsingPrefixSum(int[] arr){
		int n = arr.length;
		int[] prefixSum = new int[n];

		prefixSum[0] = arr[0];
		for(int i=1; i<n; i++)
			prefixSum[i] = prefixSum[i-1] + arr[i];

		// Print all subarrays with their respective sum
		for(int i=0; i<n; i++){
			for(int j=i; j<n; j++){
				// i, j
				/*
				int subarraySum_i_to_j = 0;
				if(i > 0){
					subarraySum_i_to_j = prefixSum[j] - prefixSum[i-1];
				}
				else{
					subarraySum_i_to_j = prefixSum[j];
				}
				*/
				int subarraySum_i_to_j = prefixSum[j] - (i > 0 ? prefixSum[i-1] : 0);
				
				System.out.println(i + " -> " + j + " = " + subarraySum_i_to_j);
			}
		}
		System.out.println();
	}


	public static void main(String[] args){
		int[] arr = {3,2,1,6,5};
		// int[] arr = {3,2,1,-6,5};
		// int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		// printAllSubarraysAndTheirSum(arr);

		System.out.println("Subarrays Sum: ");
		printAllSubarraysSum(arr);
		
		System.out.println("Subarrays Sum Optimzed Way: ");
		printAllSubarraysSumOptimized(arr);

		System.out.println("Subarrays Sum Using Prefix Sum: ");
		printAllSubarraysSumUsingPrefixSum(arr);
	}
}








