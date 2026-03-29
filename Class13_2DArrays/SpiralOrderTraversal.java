import java.util.Scanner;

/*
4 5
1 2 3 4 5
6 7 8 9 10
11 12 13 14 15 
16 17 18 19 20

3 5
1 2 3 4 5
6 7 8 9 10
11 12 13 14 15

*/

public class SpiralOrderTraversal{
    public static void spiralOrderTraversal(int[][] matrix){
        int nRows = matrix.length;
        int nCols = matrix[0].length;

        int begRow = 0, endRow = nRows-1;
        int begCol = 0, endCol = nCols-1;
        int k = 1;
        int totalElements = nRows * nCols;
        while(k <= totalElements){
            // Step-1: begRow 
            int col = begCol;
            while(k <= totalElements && col <= endCol){
                System.out.print(matrix[begRow][col] + " ");
                col++;
                k++;
            }
            begRow++;


            // Step-2: endCol
            int row = begRow;
            while(k <= totalElements && row <= endRow){
                System.out.print(matrix[row][endCol] + " ");
                row++;
                k++;
            }
            endCol--;

            // Step-3: endRow
            col = endCol;
            while(k <= totalElements && col >= begCol){
                System.out.print(matrix[endRow][col] + " ");
                col--;
                k++;
            }
            endRow--;

            // Step-4: begCol
            row = endRow;
            while(k <= totalElements && row >= begRow){
                System.out.print(matrix[row][begCol] + " ");
                row--;
                k++;
            }
            begCol++;
        }
        System.out.println();
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int nRows = scanner.nextInt();
        int nCols = scanner.nextInt();
        int[][] matrix = new int[nRows][nCols];

        for(int row=0; row<nRows; row++){
            for(int col=0; col<nCols; col++){
                matrix[row][col] = scanner.nextInt();
            }
        }

        spiralOrderTraversal(matrix);

    }
}