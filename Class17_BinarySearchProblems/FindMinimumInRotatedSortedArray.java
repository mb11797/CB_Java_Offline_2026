class Solution {
    public int findMin(int[] arr) {
        int n = arr.length;

        if(n == 1 || (arr[0] < arr[n-1])){
            return arr[0];
        }

        int l = 0, r = n-1;

        int minm = Integer.MAX_VALUE;

        while(l <= r){
            int mid = (l + r) / 2;

            if(arr[mid] > arr[mid+1]){
                // mid -> peak
                // mid + 1 -> minm
                return arr[mid+1];
            }
            else if(arr[mid] < arr[mid-1]){
                // mid - 1 -> peak
                // mid -> minm
                return arr[mid];
            }

            minm = Math.min(arr[l], Math.min(arr[mid], arr[r]));

            // check mid lies on which partition
            if(arr[mid] <= arr[n-1]){
                // mid lies on 2nd / right partition -> mid to r -> sorted range
                r = mid - 1;
            }
            else{
                // mid lies on 1st / left partition -> l to mid -> sorted
                l = mid + 1;
            }
        }

        return minm;
    }
}