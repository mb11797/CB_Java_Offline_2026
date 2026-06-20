class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> sortedStringVsListMap = new HashMap<>();

        for(String str: strs){
            char[] charArr = str.toCharArray();

            Arrays.sort(charArr);

            String sortedStr = new String(charArr);

            /*
            List<String> list;
            if(sortedStringVsListMap.containsKey(sortedStr)){
                list = sortedStringVsListMap.get(sortedStr);
            }
            else{
                list = new ArrayList<>();
            }
            list.add(str);
            sortedStringVsListMap.put(sortedStr, list);
            */
            List<String> list = sortedStringVsListMap.getOrDefault(sortedStr, new ArrayList<>());
            list.add(str);
            sortedStringVsListMap.put(sortedStr, list);
        }

        List<List<String>> ans = new ArrayList<>();

        for(Map.Entry<String, List<String>> entry: sortedStringVsListMap.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}