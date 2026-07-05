class MinStack {
    Stack<Long> stk;
    long minVal;
    public MinStack() {
        stk = new Stack<>();
        minVal = Long.MAX_VALUE;
    }
    
    public void push(int value) {
        if(stk.isEmpty()){
            minVal = (long) value;
            stk.push((long)value);
        }
        else{
            if(value < minVal){
                stk.push(2L * value - minVal);
                minVal = (long) value;
            }
            else{
                stk.push((long)value);
            }
        }
    }
    
    public void pop() {
        if(stk.peek() < minVal){
            minVal = 2 * minVal - stk.peek();         
        }
        stk.pop();
        
        if(stk.isEmpty()){
            minVal = Long.MAX_VALUE;
        }
    }
    
    public int top() {
        long ans = stk.peek();
        if(stk.peek() < minVal){
            return (int) minVal;
        }
        return (int) ans;
    }
    
    public int getMin() {
        return (int) minVal;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */