import java.util.*;

public class SnakesAndLadders{

	public static class Graph{
		private Map<Integer, Set<Integer>> adjList;
		private int nVertex;

		public Graph(int n){
			adjList = new HashMap<>();
			for(int i=1; i<=36; i++){
				adjList.put(i, new HashSet<>());
			}
			nVertex = n;
		}

		public void print(){
			System.out.println("Graph: ");
			for(Map.Entry<Integer, Set<Integer>> entry: adjList.entrySet()){
				System.out.print(entry.getKey() + " -> ");
				for(int nbr: entry.getValue()){
					System.out.print(nbr + ", ");
				}
				System.out.println();
			}
			System.out.println();
		}

		public void addEdge(int u, int v, boolean isBidirectional){
			Set<Integer> nbrsOfU = adjList.getOrDefault(u, new HashSet<>());
			nbrsOfU.add(v);
			adjList.put(u, nbrsOfU);

			if(isBidirectional){
				Set<Integer> nbrsOfV = adjList.getOrDefault(v, new HashSet<>());
				nbrsOfV.add(u);
				adjList.put(v, nbrsOfV);
			}
		}

		public int singleSourceShortestPathUsingBFS(int src, int dest){
			int[] dist = new int[nVertex+1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			int[] parent = new int[nVertex+1];
			Arrays.fill(parent, -1);

			// BFS Code:
			Queue<Integer> q = new LinkedList<>();
			dist[src] = 0;
			parent[src] = src;
			q.offer(src);

			while(!q.isEmpty()){
				int front = q.poll();

				for(int nbr: adjList.get(front)){
					if(dist[nbr] == Integer.MAX_VALUE){
						// unvisited nbr
						dist[nbr] = dist[front] + 1;
						parent[nbr] = front;
						q.offer(nbr);
					}
				}
			}

			System.out.println("Shortest Path from " + src + " to " + dest + ": ");
			int temp = dest;
			while(temp != src){
				System.out.print(temp + " <--- ");
				temp = parent[temp];
			}
			System.out.println(src);


			return dist[dest];
		}
	}

	public static void main(String[] args){
		Graph g = new Graph(36);

		int[] board = new int[37];	// by default all value = 0
		Arrays.fill(board, 0);
		board[2] = 13;
		board[5] = 2;
		board[17] = -13;
		board[18] = 11;
		board[20] = -14;
		board[24] = -8;
		board[25] = 10;
		board[32] = -2;
		board[34] = -22;

		// Populate the Graph
		for(int u=1; u<=36; u++){
			for(int dice=1; dice<=6; dice++){
				if(u + dice <= 36){
					int v = u + dice + board[u + dice];
					g.addEdge(u, v, false);
				}
			}
		}

		g.print();

		System.out.println("Minimum no of Dice Throws: " + g.singleSourceShortestPathUsingBFS(1, 36));
	}


}