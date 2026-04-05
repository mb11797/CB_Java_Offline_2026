class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int repeatingEl = 0;
        int missingEl = 0;
        int n = grid.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int curVal = Math.abs(grid[i][j]);
                int row = (curVal - 1) / n;
                int col = (curVal - 1) % n;

                if(grid[row][col] < 0){
                    // already visited
                    repeatingEl = curVal;
                }
                else{
                    // visiting 1st time
                    grid[row][col] = -1 * grid[row][col];
                }
            }
        }


        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] > 0){
                    missingEl  = (i * n + j) + 1;
                }
            }
        }

        return new int[]{repeatingEl, missingEl};
    }
}











