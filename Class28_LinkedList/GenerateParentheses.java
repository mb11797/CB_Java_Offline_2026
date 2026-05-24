class Solution {

    public void generateParenthesisRec(int open, int close, StringBuilder curAns, List<String> overallAnsList){
        if(open == 0 && close == 0){
            overallAnsList.add(curAns.toString());
            return;
        }

        // try placing open
        if(open > 0){
            curAns.append('(');
            generateParenthesisRec(open-1, close, curAns, overallAnsList);
            curAns.deleteCharAt(curAns.length()-1);
        }

        // try placing close
        if(close > open){
            curAns.append(')');
            generateParenthesisRec(open, close-1, curAns, overallAnsList);
            curAns.deleteCharAt(curAns.length()-1);
        }
        return;
    }

    public List<String> generateParenthesis(int n) {
        StringBuilder curAns = new StringBuilder();
        List<String> overallAnsList = new ArrayList<>();
        generateParenthesisRec(n, n, curAns, overallAnsList);
        return overallAnsList;
    }
}