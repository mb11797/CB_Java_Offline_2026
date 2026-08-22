class Solution {

    public int minDistanceRec(String word1, String word2, int i, int j){
        if(i < 0)
            return j+1;

        if(j < 0)
            return i+1;

        int minOperations = Integer.MAX_VALUE;
        if(word1.charAt(i) == word2.charAt(j)){
            minOperations = 0 + minDistanceRec(word1, word2, i-1, j-1);
        }
        else{
            int replace = 1 + minDistanceRec(word1, word2, i-1, j-1);
            int remove = 1 + minDistanceRec(word1, word2, i-1, j);
            int insert = 1 + minDistanceRec(word1, word2, i, j-1);

            minOperations = Math.min(replace, Math.min(remove, insert));
        }

        return minOperations;
    }

    public int minDistanceRecMemoization(String word1, String word2, int i, int j, int[][] memo){
        if(i < 0)
            return j+1;

        if(j < 0)
            return i+1;

        // lookup in memo table
        if(memo[i][j] != -1)
            return memo[i][j];

        int minOperations = Integer.MAX_VALUE;
        if(word1.charAt(i) == word2.charAt(j)){
            minOperations = 0 + minDistanceRecMemoization(word1, word2, i-1, j-1, memo);
        }
        else{
            int replace = 1 + minDistanceRecMemoization(word1, word2, i-1, j-1, memo);
            int remove = 1 + minDistanceRecMemoization(word1, word2, i-1, j, memo);
            int insert = 1 + minDistanceRecMemoization(word1, word2, i, j-1, memo);

            minOperations = Math.min(replace, Math.min(remove, insert));
        }

        return memo[i][j] = minOperations;
    }

    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] memo = new int[n1][n2];
        for(int[] row: memo)
            Arrays.fill(row, -1);
        return minDistanceRecMemoization(word1, word2, n1-1, n2-1, memo);
    }
}