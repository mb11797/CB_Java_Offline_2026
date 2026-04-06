class Solution {

    class StartBasedSortingComparator implements Comparator<int[]>{
        @Override
        public int compare(int[] a, int[] b){
            return Integer.compare(a[0], b[0]);
        }
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new StartBasedSortingComparator());

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        int[] currentInterval = result.get(0);

        int n = intervals.length;
        for(int i=1; i<n; i++){
            int currentEnd = currentInterval[1];
            int nextIntervalStart = intervals[i][0];

            if(currentEnd >= nextIntervalStart){
                // Overlapping Case
                int nextIntervalEnd = intervals[i][1];
                currentInterval[1] = Math.max(currentInterval[1], nextIntervalEnd);
            }
            else{
                // Non-Overlapping Case
                result.add(intervals[i]);
                currentInterval = result.get(result.size()-1);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}