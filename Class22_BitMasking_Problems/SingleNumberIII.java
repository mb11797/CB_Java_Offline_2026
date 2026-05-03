class Solution {
    public int[] singleNumber(int[] nums) {
        int n = nums.length;
        int xorr = 0;
        for(int el: nums){
            xorr ^= el;
        }

        int mask = (xorr & (xorr-1)) ^ xorr;

        int categA = 0;     // kth bit -> set => category
        int categB = 0;     // kth bit -> unset => category
        for(int i=0; i<n; i++){
            if((nums[i] & mask) != 0){
                // kth bit -> set 
                categA ^= nums[i];
            }
            else{
                categB ^= nums[i];
            }
        }

        return new int[] {categA, categB};
    }
}