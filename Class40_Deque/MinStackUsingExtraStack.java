class MinStack {
    Stack<Integer> stk;
    Stack<Integer> minStk;
    public MinStack() {
        stk = new Stack<Integer>();
        minStk = new Stack<Integer>();
    }
    
    public void push(int value) {
        stk.push(value);
        if(minStk.isEmpty()){
            minStk.push(value);
        }
        else{
            if(value < minStk.peek()){
                minStk.push(value);
            }
            else{
                minStk.push(minStk.peek());
            }
        }
    }
    
    public void pop() {
        stk.pop();
        minStk.pop();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return minStk.peek();
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