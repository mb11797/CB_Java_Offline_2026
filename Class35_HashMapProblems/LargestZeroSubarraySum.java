public class Solution {
    public int[] lszero(int[] arr) {
        HashMap<Integer, Integer> prefixSumVsFirstIdx = new HashMap<>();
        
        int prefixSum = 0;
        prefixSumVsFirstIdx.put(prefixSum, -1);

        int maxZeroSubarrLen = 0;
        int begIdx = -1;
        int endIdx = -1;
                
        for(int i=0; i<arr.length; i++){
            prefixSum += arr[i];
            
            if(prefixSumVsFirstIdx.containsKey(prefixSum)){
                int curZeroSubarrLen = i - prefixSumVsFirstIdx.get(prefixSum);
                if(curZeroSubarrLen > maxZeroSubarrLen){
                    maxZeroSubarrLen = curZeroSubarrLen;
                    begIdx = prefixSumVsFirstIdx.get(prefixSum);
                    endIdx = i;
                }
            }
            else{
                prefixSumVsFirstIdx.put(prefixSum, i);
            }
        }
        
        if(endIdx == -1){
            return new int[0];
        }
        
        int[] ans = new int[maxZeroSubarrLen];
        
        for(int i=begIdx+1, k=0; i<=endIdx; i++, k++){
            ans[k] = arr[i];
        }

        return ans;
    }
}
