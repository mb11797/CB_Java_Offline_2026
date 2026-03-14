class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] rotateArr = new int[n];

        k = k % n;

        for(int i=0; i<n; i++){
            rotateArr[i] = nums[(n-k + i) % n];
        }

        for(int i=0; i<n; i++)
            nums[i] = rotateArr[i];

        return;
    }
}