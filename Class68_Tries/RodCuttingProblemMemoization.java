class Solution {
    
    int maxProfitRodCutting(int[] price, int remainingRodLen){
        if(remainingRodLen == 0){
            return 0;
        }
        
        int maxProfit = 0;
        for(int cut=1; cut<=remainingRodLen; cut++){
            int curCutProfit = price[cut-1] + maxProfitRodCutting(price, remainingRodLen-cut);
            maxProfit = Math.max(maxProfit, curCutProfit);
        }
        return maxProfit;
    }
    
    int maxProfitRodCuttingMemoization(int[] price, int remainingRodLen, int[] memo){
        if(remainingRodLen == 0){
            return 0;
        }
        
        // lookup in memo table
        if(memo[remainingRodLen] != -1)
            return memo[remainingRodLen];
        
        int maxProfit = 0;
        for(int cut=1; cut<=remainingRodLen; cut++){
            int curCutProfit = price[cut-1] + maxProfitRodCuttingMemoization(price, remainingRodLen-cut, memo);
            maxProfit = Math.max(maxProfit, curCutProfit);
        }
        return memo[remainingRodLen] = maxProfit;
    }
    
    public int cutRod(int[] price) {
        // code here
        int totalRodLen = price.length;
        int[] memo = new int[totalRodLen+1];
        Arrays.fill(memo, -1);
        return maxProfitRodCuttingMemoization(price, totalRodLen, memo);
    }
}