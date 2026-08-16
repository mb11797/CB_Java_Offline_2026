class Solution {

    public int lcsBottomUpDP(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int row=0; row<=n; row++)
            dp[row][0] = 0;

        for(int col=0; col<=m; col++)
            dp[0][col] = 0;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }

    public int longestCommonSubsequence(String s1, String s2) {
        return lcsBottomUpDP(s1, s2);
    }
}