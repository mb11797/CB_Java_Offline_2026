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
    
    public int cutRod(int[] price) {
        // code here
        int totalRodLen = price.length;
        return maxProfitRodCutting(price, totalRodLen);
    }
}