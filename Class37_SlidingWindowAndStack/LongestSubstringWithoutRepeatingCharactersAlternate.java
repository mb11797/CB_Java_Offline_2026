class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> curWindowCharsSet = new HashSet<>();
        int n = s.length();
        int start = 0, en = 0;

        int maxLen = 0;
        while(en < n){
            while(!curWindowCharsSet.isEmpty() && curWindowCharsSet.contains(s.charAt(en))){
                curWindowCharsSet.remove(s.charAt(start));
                start++;
            }

            // expand window to consider new element pointed by en pointer
            curWindowCharsSet.add(s.charAt(en));
            int curLen = en - start + 1;
            // maxLen = Math.max(maxLen, curLen);
            if(curLen > maxLen){
                maxLen = curLen;
            }
            en++;
        }

        return maxLen;
    }
}