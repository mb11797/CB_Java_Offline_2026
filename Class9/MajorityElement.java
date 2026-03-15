class Solution {
    public int majorityElement(int[] nums) {
        int promisingCandidate = nums[0];
        int vote = 1;
        int n = nums.length;
        for(int i=1; i<n; i++){
            if(nums[i] == promisingCandidate){
                vote++;
            }
            else{
                vote--;
            }

            if(vote == 0){
                promisingCandidate = nums[i];
                vote = 1;
            }
        }

        vote = 0;
        for(int el: nums){
            if(el == promisingCandidate){
                vote++;
            }
        }

        if(vote > n / 2){
            return promisingCandidate;
        }

        return -1;
    }
}