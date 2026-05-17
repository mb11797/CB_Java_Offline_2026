import java.util.Scanner;
import java.util.Arrays;

/*
1 0 0 0
1 1 0 1
1 1 0 0
0 1 1 1
*/

public class RatInAMaze{

	public static void findAllPaths(int[][] maze, StringBuilder moves, int currRow, int currCol, int endRow, int endCol, boolean[][] visited){
		int n = maze.length;
		if(currRow < 0 || currRow >= n || currCol < 0 || currCol >= n || maze[currRow][currCol] == 0 || visited[currRow][currCol] == true){
			return;
		}

		if(currRow == endRow && currCol == endCol){
			System.out.println(moves.toString());
			return;
		}

		visited[currRow][currCol] = true;

		moves.insert(moves.length(), "D");
		findAllPaths(maze, moves, currRow + 1, currCol, endRow, endCol, visited);		// Down
		moves.deleteCharAt(moves.length() - 1);			// Backtracking

		moves.insert(moves.length(), "L");
		findAllPaths(maze, moves, currRow, currCol - 1, endRow, endCol, visited);		// Left
		moves.deleteCharAt(moves.length() - 1);			// Backtracking

		moves.insert(moves.length(), "R");
		findAllPaths(maze, moves, currRow, currCol + 1, endRow, endCol, visited);		// Right
		moves.deleteCharAt(moves.length() - 1);			// Backtracking

		moves.insert(moves.length(), "U");
		findAllPaths(maze, moves, currRow - 1, currCol, endRow, endCol, visited);		// Up
		moves.deleteCharAt(moves.length() - 1);			// Backtracking

		visited[currRow][currCol] = false;				// Backtracking
	}

	public static void ratInMaze(int[][] maze){
		int n = maze.length;
		boolean[][] visited = new boolean[n][n];		// by default all are false initially

		StringBuilder moves = new StringBuilder();
		findAllPaths(maze, moves, 0, 0, n-1, n-1, visited);
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter n: ");
		int n = scanner.nextInt();
		int[][] maze = new int[n][n];

		System.out.println("Enter maze of size n x n: ");
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				maze[i][j] = scanner.nextInt();
			}
		}

		ratInMaze(maze);
	}
}