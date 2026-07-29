import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/*
Enter nVertex: 
7
Enter nEdges: 
7
Enter Edges Data (line by line): 
0 1 false
1 2 false
2 3 false
3 4 false
4 5 false
5 6 false
4 1 false
Enter Source Vertex: 
0
*/

public class DetectCycleUsingDFSInDirectedGraph{

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

	public static boolean detectCycleInDirectedGraphUsingDfsHelper(List<Integer>[] adjListGraph, int node, 
		boolean[] visited, boolean[] curPathVisitedAncestorNodes){
		
		visited[node] = true;
		curPathVisitedAncestorNodes[node] = true;

		List<Integer> nbrs = adjListGraph[node];
		for(int nbr: nbrs){
			if(!visited[nbr]){
				boolean aageCycleMili = detectCycleInDirectedGraphUsingDfsHelper(adjListGraph, 
					nbr, visited, curPathVisitedAncestorNodes);
				if(aageCycleMili){
					return true;
				}
			}
			else if(curPathVisitedAncestorNodes[nbr]){
				// nbr is already visited previously in current path -> means cycle is present
				return true;
			}
		}
		curPathVisitedAncestorNodes[node] = false;
		return false;
	}

	public static boolean detectCycleInDirectedGraphUsingDfs(List<Integer>[] adjListGraph, int src){
		int nVertex = adjListGraph.length;
		boolean[] visited = new boolean[nVertex];		// by default all values false
		boolean[] curPathVisitedAncestorNodes = new boolean[nVertex];

		return detectCycleInDirectedGraphUsingDfsHelper(adjListGraph, src, visited, curPathVisitedAncestorNodes);
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

		List<Integer>[] adjListGraph = buildGraph(nVertex, edgeList);

		printGraph(adjListGraph);

		if(detectCycleInDirectedGraphUsingDfs(adjListGraph, src)){
			System.out.println("Cycle Present in Directed Graph");
		}
		else{
			System.out.println("No Cycle Present in Directed Graph");
		}

		return;
	}
}