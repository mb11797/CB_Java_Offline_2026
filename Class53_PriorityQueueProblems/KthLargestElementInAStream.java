class KthLargest {

    PriorityQueue<Integer> minPQ;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minPQ = new PriorityQueue<>();
        // insert all elements from nums[] array into minPQ, making sure the size does not go beyond k
        for(int i=0; i<nums.length; i++){
            if(i < k){
                minPQ.offer(nums[i]);
            }
            else{
                if(nums[i] > minPQ.peek()){
                    minPQ.poll();
                    minPQ.offer(nums[i]);
                }
            }
        }
    }
    
    public int add(int val) {
        if(minPQ.size() < k){
            minPQ.offer(val);
        }
        else{
            if(val > minPQ.peek()){
                minPQ.poll();
                minPQ.offer(val);
            }
        }

        return minPQ.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */