class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumVsCountMap = new HashMap<>();

        int prefixSum = 0;
        prefixSumVsCountMap.put(0, 1);

        int count = 0;
        for(int i=0; i<nums.length; i++){
            prefixSum += nums[i];

            if(prefixSumVsCountMap.containsKey(prefixSum - k)){
                count += prefixSumVsCountMap.get(prefixSum - k);   
            }
            
            prefixSumVsCountMap.put(prefixSum, prefixSumVsCountMap.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}