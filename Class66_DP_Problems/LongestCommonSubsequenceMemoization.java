class Solution {

    public int lcsRec(String s1, String s2, int i, int j){
        if(i >= s1.length() || j >= s2.length()){
            return 0;
        }

        if(s1.charAt(i) == s2.charAt(j)){
            return 1 + lcsRec(s1, s2, i+1, j+1);
        }
        else{
            int iAageBadhaoOptn = lcsRec(s1, s2, i+1, j);
            int jAageBadhaoOptn = lcsRec(s1, s2, i, j+1);
            return Math.max(iAageBadhaoOptn, jAageBadhaoOptn);
        }
    }

    public int lcsRecMemoization(String s1, String s2, int i, int j, int[][] memo){
        if(i >= s1.length() || j >= s2.length()){
            return 0;
        }

        // lookup
        if(memo[i][j] != -1){
            return memo[i][j];
        }

        int ans = 0;
        if(s1.charAt(i) == s2.charAt(j)){
            ans = 1 + lcsRecMemoization(s1, s2, i+1, j+1, memo);
        }
        else{
            int iAageBadhaoOptn = lcsRecMemoization(s1, s2, i+1, j, memo);
            int jAageBadhaoOptn = lcsRecMemoization(s1, s2, i, j+1, memo);
            ans = Math.max(iAageBadhaoOptn, jAageBadhaoOptn);
        }

        return memo[i][j] = ans;
    }

    public int longestCommonSubsequence(String s1, String s2) {
        int[][] memo = new int[s1.length()][s2.length()];
        for(int[] row: memo){
            Arrays.fill(row, -1);
        }
        return lcsRecMemoization(s1, s2, 0, 0, memo);
    }
}