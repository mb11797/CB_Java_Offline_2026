class Solution {

    public void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        int n = nums.length;

        if(n == 1)
            return;

        while(j < n){
            // j<n
            while(j<n && nums[j] == 0){
                j++;
            }

            if(j == n){
                return;
            }

            swap(nums, i++, j++);
        }
    }
}