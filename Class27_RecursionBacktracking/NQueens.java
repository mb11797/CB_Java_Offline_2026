import java.util.Scanner;
import java.util.Arrays;

public class NQueens{

	public static boolean kyaQueenRakhPaaye(char[][] board, int row, int col){
		int n = board.length;
		// Vertical Check : Same Column Check
		for(int r=0; r<row; r++){
			if(board[r][col] == 'Q'){
				return false;
			}
		}

		// Left Diagonal Check
		for(int r=row, c=col; r>=0 && c>=0; r--, c--){
			if(board[r][c] == 'Q'){
				return false;
			}
		}

		// Right Diagonal Check
		for(int r=row, c=col; r>=0 && c<n; r--, c++){
			if(board[r][c] == 'Q'){
				return false;
			}
		}
		
		return true;
	}

	public static void printBoard(char[][] board){
		int n = board.length;

		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}


	public static void solveNQueensRec(char[][] board, int row){
		int n = board.length;

		if(row == n){
			printBoard(board);
			return;
		}

		for(int col=0; col<n; col++){
			if(kyaQueenRakhPaaye(board, row, col)){
				board[row][col] = 'Q';
				solveNQueensRec(board, row+1);
				board[row][col] = '.';			// Backtracking
			}
		}
	}

	public static void solveNQueens(int n){
		// n x n -> chess board
		char[][] board = new char[n][n];

		for(char[] row: board){
			Arrays.fill(row, '.');
		}

		printBoard(board);

		solveNQueensRec(board, 0, ans);
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter n: ");
		int n = scanner.nextInt();

		solveNQueens(n);

	}
}