class Solution {

    public int binarySearch(int[] arr, int target, boolean searchFirstOccurence){
        int n = arr.length;
        int ans = -1;
        int low = 0, high = n-1;

        while(low <= high){
            int mid = (low + high) / 2;

            if(arr[mid] < target){
                low = mid + 1;
            }
            else if(arr[mid] > target){
                high = mid - 1;
            }
            else{
                // a[mid] == target
                ans = mid;
                if(searchFirstOccurence){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
        }

        return ans;
    }

    public int[] searchRange(int[] arr, int target) {
        return new int[]{binarySearch(arr, target, true), binarySearch(arr, target, false)};
    }
}