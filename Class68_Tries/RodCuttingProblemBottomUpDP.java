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
    
    int maxProfitRodCuttingBottomUp(int[] price){
        int rodLen = price.length;
        int[] dp = new int[rodLen+1];
        
        dp[0] = 0;
        dp[1] = price[0];
        
        for(int len=2; len<=rodLen; len++){
            dp[len] = 0;
            for(int cut=1; cut<=len; cut++){
                int curCutProfit = price[cut-1] + dp[len-cut];
                dp[len] = Math.max(dp[len], curCutProfit);
            }
        }
        
        return dp[rodLen];
    }
    
    public int cutRod(int[] price) {
        // code here
        int totalRodLen = price.length;
        int[] memo = new int[totalRodLen+1];
        Arrays.fill(memo, -1);
        return maxProfitRodCuttingBottomUp(price);
    }
}