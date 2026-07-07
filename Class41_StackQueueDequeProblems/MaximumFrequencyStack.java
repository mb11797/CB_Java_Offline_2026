class FreqStack {
    Map<Integer, Integer> elmtVsFreqMap;
    Map<Integer, Stack<Integer>> freqVsStackMap;        // to maintain ordering of elements with same frequency
    int maxFreq;
    public FreqStack() {
        elmtVsFreqMap = new HashMap<>();
        freqVsStackMap = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int curFreq = elmtVsFreqMap.getOrDefault(val, 0);
        curFreq++;
        Stack<Integer> curFreqStack = freqVsStackMap.getOrDefault(curFreq, new Stack<>());
        curFreqStack.push(val);
        freqVsStackMap.put(curFreq, curFreqStack);
        elmtVsFreqMap.put(val, curFreq);
        maxFreq = Math.max(maxFreq, curFreq);
    }
    
    public int pop() {
        int poppedElmt = freqVsStackMap.get(maxFreq).pop();
        elmtVsFreqMap.put(poppedElmt, elmtVsFreqMap.get(poppedElmt)-1);
        if(freqVsStackMap.get(maxFreq).isEmpty()){
            maxFreq--;
        }
        return poppedElmt;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */