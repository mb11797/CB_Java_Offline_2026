class Solution {

    public int firstOccurence(int[] arr, int target){
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
                high = mid - 1;
            }
        }

        return ans;
    }

    public int lastOccurence(int[] arr, int target){
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
                low = mid + 1;
            }
        }

        return ans;
    }

    public int[] searchRange(int[] arr, int target) {
        return new int[]{firstOccurence(arr, target), lastOccurence(arr, target)};
    }
}