class MedianFinder {

    PriorityQueue<Integer> leftMaxPQ;
    PriorityQueue<Integer> rightMinPQ;

    public MedianFinder() {
        leftMaxPQ = new PriorityQueue<>(Collections.reverseOrder());
        rightMinPQ = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(leftMaxPQ.isEmpty() || num < leftMaxPQ.peek()){
            leftMaxPQ.offer(num);
        }
        else{
            rightMinPQ.offer(num);
        }

        if(leftMaxPQ.size() - rightMinPQ.size() > 1){
            rightMinPQ.offer(leftMaxPQ.poll());
        }
        else if(rightMinPQ.size() - leftMaxPQ.size() > 1){
            leftMaxPQ.offer(rightMinPQ.poll());
        }
    }
    
    public double findMedian() {
        if(leftMaxPQ.size() == rightMinPQ.size()){
            return (double) (leftMaxPQ.peek() + rightMinPQ.peek()) / 2.0;
        }
        else if(leftMaxPQ.size() > rightMinPQ.size()){
            return (double) leftMaxPQ.peek();
        }
        else{
            return (double) rightMinPQ.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */