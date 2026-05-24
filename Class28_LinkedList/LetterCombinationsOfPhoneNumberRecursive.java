class Solution {
    String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public void letterCombinationsRec(String digits, int idx, StringBuilder curAns, List<String> ans){
        if(idx == digits.length()){
            ans.add(curAns.toString());
            return;
        }

        char digit = digits.charAt(idx);
        String str = mapping[digit - '0'];
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            curAns.append(ch);
            letterCombinationsRec(digits, idx+1, curAns, ans);
            curAns.deleteCharAt(curAns.length()-1);
        }
    }

    public List<String> letterCombinations(String digits) {
        StringBuilder curAns = new StringBuilder("");
        System.out.println(curAns.toString());
        List<String> ans = new ArrayList<>();
        letterCombinationsRec(digits, 0, curAns, ans);
        return ans;
    }
}

/*
class MainClass{
    main(){
        Solution obj = new Solution();
        String digitsTestCase1 = "234";
        List<String> ans = obj.letterCombinations(digitsTestCase1);
        // verify
        String digitsTestCase2 = "68";
        ans = obj.letterCombinations(digitsTestCase1);
        // verify

        String digitsTestCase3 = "594";
        ans = obj.letterCombinations(digitsTestCase1);

    }
}
*/