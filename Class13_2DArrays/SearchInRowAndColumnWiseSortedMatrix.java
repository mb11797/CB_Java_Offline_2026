class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int nRows = matrix.length;
        int nCols = matrix[0].length;
        int row = 0, col = nCols-1;

        while(row < nRows && col >= 0){
            if(target > matrix[row][col]){
                row++;
            }
            else if(target < matrix[row][col]){
                col--;
            }
            else{
                return true;
            }
        }

        return false;
    }
}