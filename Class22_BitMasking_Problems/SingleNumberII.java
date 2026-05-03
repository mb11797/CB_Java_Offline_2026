class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        int n = nums.length;

        for(int k=0; k<32; k++){
            int kthBitSum = 0;
            int mask = 1 << k;

            for(int i=0; i<nums.length; i++){
                if((nums[i] & mask) != 0){
                    kthBitSum++;
                }
            }

            if((kthBitSum % 3) == 1){
                ans = ans | mask;
            }            
        }

        return ans;
    }
}