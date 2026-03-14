class Solution {
    public int subarraySum(int[] arr, int k) {
        int n = arr.length;
        int[] prefixSum = new int[n];
        
        prefixSum[0] = arr[0];
        for(int i=1; i<n; i++){
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        int count = 0;

        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int subarraySum = 0;
                if(i == 0){
                    subarraySum = prefixSum[j];
                }
                else{
                    subarraySum = prefixSum[j] - prefixSum[i-1];
                }
                
                if(subarraySum == k){
                    count++;
                }
            }
        }

        return count;
    }
}