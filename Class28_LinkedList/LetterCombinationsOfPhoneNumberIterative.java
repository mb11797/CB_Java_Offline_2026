class Solution {
    String[] mapping = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        // digits = "234"
        List<String> res = new ArrayList<>();
        res.add("");
        for(int k=0; k<digits.length(); k++){
            char digit = digits.charAt(k);
            String str = mapping[digit - '0'];     // "234" -> 2, 3, 4
            List<String> tempRes = new ArrayList<>();

            // 2 -> "abc"; res = [""]
            
            // 3 -> "def"; res = ["a", "b", "c"]
            // 'd' ->  ["a", "b", "c"] =>  newRes.add(["ad", "bd", "cd"])
            // 'e' ->  ["a", "b", "c"] =>  newRes.add(["ae", "be", "ce"])
            // 'f' ->  ["a", "b", "c"] =>  newRes.add(["af", "bf", "cf"])

            // 4 -> "ghi"; res = ["ad", "bd", "cd", "ae", "be", "ce", "af", "bf", "cf"]
            // 'g' -> ["ad", "bd", "cd", "ae", "be", "ce", "af", "bf", "cf"] => newRes.add(["adg", "bdg", "cdg", "aeg", "beg", "ceg", "afg", "bfg", "cfg"])
            // 'h' -> ...
            // 'i' -> ...
            for(int i=0; i<str.length(); i++){
                char ch = str.charAt(i);        // d,e,f

                // res = ["a", "b", "c"]
                for(int j=0; j<res.size(); j++){
                    tempRes.add(res.get(j) + ch);
                }
            }

            res = tempRes;
            // res => ["ad", "bd", "cd", "ae", "be", "ce", "af", "bf", "cf"]
        }
        return res;
    }
}
