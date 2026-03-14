class Solution {

    public void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public int removeDuplicates(int[] nums) {
        
        int i = 0, j = 0;
        int n = nums.length;

        while(j < n){
            // j < n
            while(j+1<n && nums[j] == nums[j+1]){
                j++;
                continue;
            }

            swap(nums, i, j);
            i++;
            j++;
        }

        return i;
    }
}

/*
class Solution {

    public int removeDuplicates(int[] nums) {
        
        int i = 0, j = 0;
        int n = nums.length;

        while(j < n){
            // j < n
            while(j+1<n && nums[j] == nums[j+1]){
                j++;
                continue;
            }

            nums[i] = nums[j];
            i++;
            j++;
        }

        return i;
    }
}
*/