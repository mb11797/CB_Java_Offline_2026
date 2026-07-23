class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int i=0; i<k; i++){
            minHeap.add(arr[i]);
        }
        
        for(int i=k; i<n; i++){
            if(arr[i] > minHeap.peek()){
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        while(!minHeap.isEmpty()){
            ans.add(minHeap.poll());
        }
        
        Collections.reverse(ans);
        
        return ans;
    }
}
