class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> prefixSumVsFirstIdxMap = new HashMap<>();
        // Wt(0) = -1
        // Wt(1) = +1
        int prefixSum = -1;

        prefixSumVsFirstIdxMap.put(prefixSum, -1);
        int maxZeroSubarraySumLen = 0;

        for(int i=0; i<nums.length; i++){
            prefixSum += nums[i] == 0 ? -1 : 1;

            if(prefixSumVsFirstIdxMap.containsKey(prefixSum)){
                int curZeroSubarraySumLen = i - prefixSumVsFirstIdxMap.get(prefixSum);
                maxZeroSubarraySumLen = Math.max(maxZeroSubarraySumLen, curZeroSubarraySumLen);
            }    
            else{
                prefixSumVsFirstIdxMap.put(prefixSum, i);
            }        
        }

        return maxZeroSubarraySumLen;
    }
}