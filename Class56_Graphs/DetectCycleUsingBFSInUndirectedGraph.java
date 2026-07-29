import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/*
Enter nVertex: 
6
Enter nEdges: 
6
Enter Edges Data (line by line): 
0 2 true
0 1 
2 3 true
3 1 
1 4 true
4 5 true
Enter Source Vertex: 
0
*/

/*
6
6
0 2 true
0 1 
2 3 true
3 1 
1 4 true
4 5 true
0
*/

public class DetectCycleUsingBFSInUndirectedGraph{

	public static class Edge{
		int u;
		int v;
		boolean isBidirectional;

		public Edge(int u, int v, boolean isBidirectional){
			this.u = u;
			this.v = v;
			this.isBidirectional = isBidirectional;
		}
	}

	private static List<Integer>[] buildGraph(int nVertex, List<Edge> edgeList){
		// int nEdges = edgeList.size();
		List<Integer>[] adjListGraph = new ArrayList[nVertex];

		for(int i=0; i<nVertex; i++){
			adjListGraph[i] = new ArrayList<>();
		}

		for(Edge edge: edgeList){
			int u = edge.u;
			int v = edge.v;
			boolean isBidirectional = edge.isBidirectional;
			adjListGraph[u].add(v);
			if(isBidirectional){
				adjListGraph[v].add(u);
			}
		}

		return adjListGraph;
	}

	public static void printGraph(List<Integer>[] graph){
		System.out.println("Graph (Adjacency List Representation): ");
		for(int i=0; i<graph.length; i++){
			List<Integer> nbrs = graph[i];
			System.out.print("Vertex " + i + " -> ");
			for(int nbr: nbrs){
				System.out.print(nbr + ", ");
			}
			System.out.println();
		}
		System.out.println();
		return;
	}

	public static void bfs(List<Integer>[] adjListGraph, int src, int nVertex){
		boolean[] visited = new boolean[nVertex];		// by default all values false

		Queue<Integer> q = new LinkedList<>();
		q.offer(src);

		while(!q.isEmpty()){
			int front = q.poll();

			if(visited[front]){
				continue;
			}

			// print
			System.out.print(front + " ");

			// mark visited
			visited[front] = true;

			// explore neighbours
			List<Integer> nbrs = adjListGraph[front];
			for(int nbr: nbrs){
				if(!visited[nbr]){
					q.offer(nbr);
				}
			}
		}
		return;
	}

	public static void dfs(List<Integer>[] adjListGraph, int src, boolean[] visited){
		System.out.print(src + " ");
		// mark visited
		visited[src] = true;

		// explore neighbours
		List<Integer> nbrs = adjListGraph[src];
		for(int nbr: nbrs){
			if(!visited[nbr]){
				dfs(adjListGraph, nbr, visited);
			}
		}
	}

	public static boolean detectCycleUsingDFS(List<Integer>[] adjListGraph, boolean[] visited, 
		int node, int parentNode){

		visited[node] = true;

		// explore neighbours
		for(int nbr: adjListGraph[node]){
			if(!visited[nbr]){
				boolean cycleHai = detectCycleUsingDFS(adjListGraph, visited, nbr, node);
				if(cycleHai)
					return true;
			}
			else if(visited[nbr] && nbr != parentNode){
				return true;
			}
		}

		return false;
	}

	public static class Pair{
		int node;
		int parent;

		public Pair(int node, int parent){
			this.node = node;
			this.parent = parent;
		}
	}

	public static boolean detectCycleUsingBFS(List<Integer>[] adjListGraph, int src){
		int nVertex = adjListGraph.length;
		boolean[] visited = new boolean[nVertex];
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(src, -1));		// node = src, parent = -1
		visited[src] = true;

		while(!q.isEmpty()){
			Pair frontPair = q.poll();
			int node = frontPair.node;
			int parent = frontPair.parent;

			for(int nbr: adjListGraph[node]){
				if(!visited[nbr]){
					q.offer(new Pair(nbr, node));
					visited[nbr] = true;
				}
				else if(nbr != parent){
					// nbr is visited and nbr is also not parent
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter nVertex: ");
		int nVertex = Integer.parseInt(br.readLine());		// br.readLine() -> throws IOException
		System.out.println("Enter nEdges: ");
		int nEdges = Integer.parseInt(br.readLine());

		System.out.println("Enter Edges Data (line by line): ");
		List<Edge> edgeList = new ArrayList<>();
		for(int i=0; i<nEdges; i++){
			String inputEdgeData = br.readLine();	
			// inputEdgeData = "2 3 false"
			// inputEdgeData = "2 3"
			String[] parts = inputEdgeData.split(" ");	
			// parts[0] = "2", parts[1] = "3", parts[2] = "false"
			int u = Integer.parseInt(parts[0]);		// u = 2 (int)
			int v = Integer.parseInt(parts[1]);		// v = 3 (int)
			boolean isBidirectional;
			if(parts.length > 2){
				isBidirectional = parts[2].equals("true") ? true : false;
			}
			else{
				isBidirectional = true;
			}
			Edge edge = new Edge(u, v, isBidirectional);
			edgeList.add(edge);
		}

		System.out.println("Enter Source Vertex: ");
		int src = Integer.parseInt(br.readLine());

		boolean[] visited = new boolean[nVertex];		// by default all values false
		List<Integer>[] adjListGraph = buildGraph(nVertex, edgeList);

		printGraph(adjListGraph);

		System.out.println("DFS Traversal of Graph: ");
		dfs(adjListGraph, src, visited);
		System.out.println();

		visited = new boolean[nVertex];
		if(detectCycleUsingDFS(adjListGraph, visited, src, -1)){
			System.out.println("Cycle Exists in Graph using DFS");
		}
		else{
			System.out.println("No Cycle in Graph");
		}

		if(detectCycleUsingBFS(adjListGraph, src)){
			System.out.println("Cycle Exists in Graph using BFS");
		}
		else{
			System.out.println("No Cycle in Graph");			
		}

		return;
	}
}