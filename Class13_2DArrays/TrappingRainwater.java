class Solution {
    public int trap(int[] height) {
        int totalWater = 0;
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rytMax = new int[n];

        leftMax[0] = height[0];
        for(int i=1; i<n; i++){
            leftMax[i] = Math.max(leftMax[i-1], hight[i]);
        }
        
        rytMax[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--){
            rytMax[i] = Math.max(rytMax[i+1], height[i]);
        }

        for(int i=0; i<n; i++){
            totalWater += Math.min(leftMax[i], rytMax[i]) - height[i];
        }
        return totalWater;
    }
}