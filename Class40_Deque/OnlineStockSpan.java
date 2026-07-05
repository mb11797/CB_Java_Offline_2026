/*
["StockSpanner", "next", "next", "next", "next", "next", "next", "next"] 
[      [],        [100],  [80],   [60],   [70],   [60],   [75],   [85]] 
*/

class StockSpanner {

    private class Pair{
        int price;
        int dayIdx;

        public Pair(int price, int dayIdx){
            this.price = price;
            this.dayIdx = dayIdx;
        }
    }

    int dayIdx;
    Stack<Pair> stk;

    public StockSpanner() {
        dayIdx = 0;
        stk = new Stack<>();
    }
    
    public int next(int price) {

    	while(!stk.isEmpty() && price >= stk.peek().price){
    		stk.pop();
    	}

    	int span;
    	if(stk.isEmpty()){
    		span = dayIdx - (-1);
    	}
    	else{
    		span = dayIdx - stk.peek().dayIdx;
    	}

    	stk.push(new Pair(price, dayIdx));
    	dayIdx++;
        
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */