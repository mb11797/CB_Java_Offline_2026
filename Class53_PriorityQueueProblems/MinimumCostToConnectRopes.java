class Solution {
    public static int minCost(int[] arr) {
        // code here
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        for(int el: arr)
            minPQ.offer(el);
        
        int totalCost = 0;
        while(minPQ.size() > 1){
            int minRope = minPQ.poll();
            int secondMinRope = minPQ.poll();
            
            minPQ.offer(minRope + secondMinRope);
            int cost = minRope + secondMinRope;
            totalCost += cost;
        }
        
        return totalCost;
    }
}