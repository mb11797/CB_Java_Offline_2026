class Solution {

    public void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public void reverse(int[] nums, int beg, int en){
        while(beg < en){
            swap(nums, beg++, en--);
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n < 2){
            return;
        }
        int i = n-2;

        while(i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }

        if(i == -1){
            reverse(nums, 0, n-1);
            return;
        }

        int peakIdx = i+1;
        int elmtOfInterestIdx = i;

        // i + 1 -> peak
        // element of interest = i

        i = n-1;
        while(i > elmtOfInterestIdx){
            if(nums[i] > nums[elmtOfInterestIdx]){
                swap(nums, i, elmtOfInterestIdx);
                reverse(nums, elmtOfInterestIdx+1, n-1);
                break;
            }
            i--;
        }

        return;
    }
}