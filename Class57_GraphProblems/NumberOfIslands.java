class Solution {
    public int[][] dirns = {{1,0},{0,-1},{-1,0},{0,1}};

    public void dfs(int i, int j, char[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j] == '0'){
            return;
        }

        grid[i][j] = '0';

        for(int k=0; k<4; k++){
            dfs(i+dirns[k][0], j+dirns[k][1], grid);
        }

        return;
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int numOfIslands = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    numOfIslands++;
                    dfs(i, j, grid);
                }
            }
        }

        return numOfIslands;
    }
}