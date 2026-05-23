import java.util.Scanner;

/*

5 3 . . 7 . . . . 
6 . . 1 9 5 . . . 
. 9 8 . . . . 6 . 
8 . . . 6 . . . 3 
4 . . 8 . 3 . . 1 
7 . . . 2 . . . 6 
. 6 . . . . 2 8 . 
. . . 4 1 9 . . 5 
. . . . 8 . . 7 9

*/


public class SudokuSolver{

	public static void printBoard(char[][] board){
		int n = board.length;

		System.out.println("Sudoku Board: ");
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static boolean canPlaceNo(char[][] board, int row, int col, int no){
		char noInChar = (char)('0' + no);
		// Same Row Check
		for(int c=0; c<9; c++){
			if(board[row][c] == noInChar){
				return false;
			}
		}

		// Same Column Check
		for(int r=0; r<9; r++){
			if((int)(board[r][col]-'0') == no){
				return false;
			}
		}

		// Same Grid Check
		int gridStartX = 3 * (row / 3);
		int gridStartY = 3 * (col / 3);

		for(int i=gridStartX; i<gridStartX+3; i++){
			for(int j=gridStartY; j<gridStartY+3; j++){
				if(board[i][j] == noInChar){
					return false;
				}
			}
		}

		return true;
	}


	public static boolean sudokuSolverRec(char[][] board, int row, int col){
		if(row == 9){
			// board solved -> base case
			printBoard(board);
			return true;
		}

		if(col == 9){
			return sudokuSolverRec(board, row+1, 0);
		}

		if(board[row][col] != '.'){
			return sudokuSolverRec(board, row, col+1);
		}

		for(int no=1; no<=9; no++){
			if(canPlaceNo(board, row, col, no)){
				board[row][col] = (char)('0' + no);
				boolean aageSolveKarPaaye = sudokuSolverRec(board, row, col+1);
				if(aageSolveKarPaaye){
					return true;
				}
				board[row][col] = '.';			// backtracking
			}
		}

		return false;
	}

	public static void sudokuSolver(char[][] board){
		sudokuSolverRec(board, 0, 0);
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		char[][] board = new char[9][9];
		System.out.println("Input Board: ");
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				board[i][j] = scanner.next().charAt(0);
			}
		}

		printBoard(board);

		sudokuSolver(board);

		printBoard(board);
	}
}