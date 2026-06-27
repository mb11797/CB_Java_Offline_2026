class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> curWindowCharsSet = new HashSet<>();
        int n = s.length();
        int start = 0, en = 0;
        int ansStart = -1, ansEnd = -1;

        int maxLen = 0;
        while(en < n){
            if(curWindowCharsSet.contains(s.charAt(en))){
                // remove from start of window
                curWindowCharsSet.remove(s.charAt(start));
                start++;
            }
            else{
                // expand window to consider new element pointed by en pointer
                curWindowCharsSet.add(s.charAt(en));
                int curLen = en - start + 1;
                // maxLen = Math.max(maxLen, curLen);
                if(curLen > maxLen){
                    maxLen = curLen;
                    ansStart = start;
                    ansEnd = en;
                }
                en++;
            }
        }

        return maxLen;
        // return s.substring(ansStart, ansEnd+1);
    }
}