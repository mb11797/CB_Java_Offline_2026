public class Solution {
    public int[] dNums(int[] arr, int k) {
        int n = arr.length;
        HashMap<Integer, Integer> elmtVsCount = new HashMap<>();
        int[] ans = new int[n-k+1];

        int i;
        for(i=0; i<k; i++){
            elmtVsCount.put(arr[i], elmtVsCount.getOrDefault(arr[i], 0) + 1);
        }
        // i = k

        int ptr = 0;
        ans[ptr++] = elmtVsCount.size();

        for(i=k; i<n; i++){
            // add -> arr[i]
            // remove -> arr[i-k]
            elmtVsCount.put(arr[i], elmtVsCount.getOrDefault(arr[i], 0) + 1);
            elmtVsCount.put(arr[i-k], elmtVsCount.get(arr[i-k]) - 1);

            if(elmtVsCount.get(arr[i-k]) == 0){
                elmtVsCount.remove(arr[i-k]);
            }
            
            ans[ptr] = elmtVsCount.size();
            ptr++;
        }

        return ans;
    }
}
