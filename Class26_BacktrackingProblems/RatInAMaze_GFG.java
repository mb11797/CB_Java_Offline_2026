class Solution {
    
    public void findAllPaths(int[][] maze, StringBuilder moves, int currRow, int currCol, int endX, int endY, boolean[][] visited, ArrayList<String> ans){
		int n = maze.length;
		if(currRow < 0 || currRow >= n || currCol < 0 || currCol >= n || maze[currRow][currCol] == 0 || visited[currRow][currCol] == true){
			return;
		}

		if(currRow == endX && currCol == endY){
			ans.add(moves.toString());
			return;
		}

		visited[currRow][currCol] = true;

		moves.insert(moves.length(), "D");
		findAllPaths(maze, moves, currRow + 1, currCol, endX, endY, visited, ans);		// Down
		moves.deleteCharAt(moves.length() - 1);

		moves.insert(moves.length(), "L");
		findAllPaths(maze, moves, currRow, currCol - 1, endX, endY, visited, ans);		// Left
		moves.deleteCharAt(moves.length() - 1);

		moves.insert(moves.length(), "R");
		findAllPaths(maze, moves, currRow, currCol + 1, endX, endY, visited, ans);		// Right
		moves.deleteCharAt(moves.length() - 1);

		moves.insert(moves.length(), "U");
		findAllPaths(maze, moves, currRow - 1, currCol, endX, endY, visited, ans);		// Up
		moves.deleteCharAt(moves.length() - 1);

		visited[currRow][currCol] = false;				// Backtracking
	}
    
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        int n = maze.length;
		boolean[][] visited = new boolean[n][n];		// by default all are false initially

		StringBuilder moves = new StringBuilder();
		ArrayList<String> ans = new ArrayList<>();
		findAllPaths(maze, moves, 0, 0, n-1, n-1, visited, ans);
		return ans;
    }
}