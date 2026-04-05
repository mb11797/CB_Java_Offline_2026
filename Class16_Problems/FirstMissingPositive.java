class Solution {
    public int firstMissingPositive(int[] arr) {
        int n = arr.length;
        // Step - 1
        for(int i=0; i<n; i++){
            if(arr[i] <= 0){
                arr[i] = n+1;
            }
        }

        // Step - 2:
        for(int i=0; i<n; i++){
            if(Math.abs(arr[i]) <= n){
                // M-1:
                // int idx = Math.abs(arr[i]) - 1
                // arr[idx] = -1 * Math.abs(arr[idx]);
                // M-2: Alternate way of above 2 lines
                arr[Math.abs(arr[i]) - 1] = -1 * Math.abs(arr[Math.abs(arr[i]) - 1]);
            }
        }

        // Step-3:
        for(int i=0; i<n; i++){
            if(arr[i] > 0){
                return i+1;
            }
        }

        return n+1;
    }
}



