class Solution {
    public int search(int[] arr, int target) {
        int n = arr.length;
        int l = 0, r = n-1;

        while(l <= r){
            int mid = (l + r) / 2;

            if(target == arr[mid]){
                return mid;
            }
            // Find out mid lies on which partition
            if(arr[0] <= arr[mid]){
                // mid lies on 1st partition => l to mid -> sorted
                if(arr[l] <= target && target < arr[mid]){
                    r = mid - 1;
                }
                else{
                    l = mid + 1;
                }
            }
            else{
                // mid lies on 2nd Partition => mid to r -> sorted
                if(arr[mid] < target && target <= arr[r]){
                    l = mid + 1;
                }
                else{
                    r = mid - 1;
                }
            }
        }

        return -1;
    }
}