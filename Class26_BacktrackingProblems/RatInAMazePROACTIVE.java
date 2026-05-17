import java.util.Scanner;
import java.util.Arrays;

/*
1 0 0 0
1 1 0 1
1 1 0 0
0 1 1 1
*/

public class RatInAMazePROACTIVE{

	public static void findAllPaths(int[][] maze, StringBuilder moves, int currRow, int currCol, int endRow, int endCol, boolean[][] visited){
		int n = maze.length;

		if(currRow == endRow && currCol == endCol){
			System.out.println(moves.toString());
			return;
		}

		// D, L, R, U
		String dirns = "DLRU";
		int[] dirnRow = {1, 0, 0, -1};
		int[] dirnCol = {0, -1, 1, 0};

		for(int i=0; i<4; i++){
			int newRow = currRow + dirnRow[i];
			int newCol = currCol + dirnCol[i];

			if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && maze[newRow][newCol] == 1 && !visited[newRow][newCol]){
				visited[newRow][newCol] = true;
				moves.insert(moves.length(), dirns.charAt(i));
				findAllPaths(maze, moves, newRow, newCol, n-1, n-1, visited);
				visited[newRow][newCol] = false;				// Backtracking
				moves.deleteCharAt(moves.length() - 1);		// Backtracking

			}
		}

		
	}

	public static void ratInMaze(int[][] maze){
		if(maze[0][0] == 0){
			return;
		}
		int n = maze.length;
		boolean[][] visited = new boolean[n][n];		// by default all are false initially

		StringBuilder moves = new StringBuilder();
		visited[0][0] = true;
		findAllPaths(maze, moves, 0, 0, n-1, n-1, visited);
		visited[0][0] = false;
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