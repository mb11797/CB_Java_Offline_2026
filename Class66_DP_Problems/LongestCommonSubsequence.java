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

    public int longestCommonSubsequence(String s1, String s2) {
        return lcsRec(s1, s2, 0, 0);
    }
}