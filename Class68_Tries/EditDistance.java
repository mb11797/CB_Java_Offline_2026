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

    public int minDistance(String word1, String word2) {
        return minDistanceRec(word1, word2, word1.length()-1, word2.length()-1);
    }
}