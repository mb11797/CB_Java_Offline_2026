import java.util.*;
import java.io.*;

public class BellmanFordAlgorithm{

	public static class Edge implements Comparable<Edge>{
		int u;
		int v;
		int wt;
		boolean isBidirectional;
		public Edge(int u, int v, int wt, boolean isBidirectional){
			this.u = u;
			this.v = v;
			this.wt = wt;
			this.isBidirectional = isBidirectional;
		}

		@Override
		public int compareTo(Edge other){
			return this.wt - other.wt;
		}
	}

	public static class Pair{
		int node;
		int wt;
		public Pair(int node, int wt){
			this.node = node;
			this.wt = wt;
		}
	}

	public static void printGraph(List<Pair>[] adjListGraph){
		System.out.println("Printing Graph: ");
		int nVertex = adjListGraph.length;
		for(int i=0; i<nVertex; i++){
			System.out.print(i + " -> ");
			for(Pair p: adjListGraph[i]){
				System.out.print("(" + p.node + ", " + p.wt + ")");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static List<Pair>[] buildGraph(int nVertex, List<Edge> edgeList){
		List<Pair>[] adjListGraph = new ArrayList[nVertex];
		for(int i=0; i<nVertex; i++){
			adjListGraph[i] = new ArrayList<>();
		}
		for(Edge edge: edgeList){
			int u = edge.u;
			int v = edge.v;
			int wt = edge.wt;
			boolean isBidirectional = edge.isBidirectional;
			List<Pair> nbrsOfU = adjListGraph[u];
			nbrsOfU.add(new Pair(v, wt));
			adjListGraph[u] = nbrsOfU;
			if(isBidirectional){
				List<Pair> nbrsOfV = adjListGraph[v];
				nbrsOfV.add(new Pair(u, wt));
				adjListGraph[v] = nbrsOfV;			
			}
		}
		return adjListGraph;
	}

	public static void printEdgeList(List<Edge> edgeList){
		System.out.println("Printing Edge List: ");
		for(Edge edge: edgeList){
			System.out.println(edge.u + ", " + edge.v + ", " + edge.wt);
		}
		System.out.println();
	}

	public static int[] singleSourceShortestPathUsingBellmanFord(int nVertex, List<Edge> edgeList, int src){
		int[] path = new int[nVertex];
		Arrays.fill(path, Integer.MAX_VALUE);
		path[src] = 0;

		for(int i=1; i<=nVertex-1; i++){
			// ith iteration -> Go to each edge and try to perform relaxation of edge
			for(Edge edge: edgeList){
				int u = edge.u;
				int v = edge.v;
				int wt = edge.wt;

				if(path[u] == Integer.MAX_VALUE){
					continue;
				}

				if(path[u] + wt < path[v]){
					path[v] = path[u] + wt;
				}
			}
		}

		return path;
	}

	public static boolean detectNegativeWightCycleInGraphUsingBellmanFord(int nVertex, List<Edge> edgeList, int src){
		int[] path = new int[nVertex];
		Arrays.fill(path, Integer.MAX_VALUE);
		path[src] = 0;

		for(int i=1; i<=nVertex-1; i++){
			// ith iteration -> Go to each edge and try to perform relaxation of edge
			for(Edge edge: edgeList){
				int u = edge.u;
				int v = edge.v;
				int wt = edge.wt;

				if(path[u] == Integer.MAX_VALUE){
					continue;
				}

				if(path[u] + wt < path[v]){
					path[v] = path[u] + wt;
				}
			}
		}

		for(Edge edge: edgeList){
			int u = edge.u;
			int v = edge.v;
			int wt = edge.wt;

			if(path[u] == Integer.MAX_VALUE){
				continue;
			}

			if(path[u] + wt < path[v]){
				return true;
			}
		}

		return false;
	}


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter no of Vertex: ");
		int nVertex = Integer.parseInt(br.readLine());
		System.out.println("Enter no of Edges: ");
		int nEdges = Integer.parseInt(br.readLine());

		System.out.println("Enter Edges Info: ");
		List<Edge> edgeList = new ArrayList<>();	
		for(int i=0; i<nEdges; i++){
			String inputLine = br.readLine();			// inputLine = "0 1 10 true"
			String[] parts = inputLine.split(" ");		// parts[4] = {"0", "1", "10", "true"}
			int u = Integer.parseInt(parts[0]);			// parts[0] = "0"
			int v = Integer.parseInt(parts[1]);			// parts[1] = "1"
			int wt = Integer.parseInt(parts[2]);		// parts[2] = "10"
			boolean isBidirectional;
			if(parts.length > 3){
				isBidirectional = parts[3].equals("true") ? true : false;		// parts[3] = "true"
			}
			else{
				isBidirectional = true;
			}
			edgeList.add(new Edge(u, v, wt, isBidirectional));
		}

		System.out.println("Enter Source Vertex: ");
		int src = Integer.parseInt(br.readLine());

		int[] pathCost = singleSourceShortestPathUsingBellmanFord(nVertex, edgeList, src);
		for(int i=0; i<pathCost.length; i++){
			System.out.println(src + " -> " + i + ": cost = " + pathCost[i]);
		}
		System.out.println();

		if(detectNegativeWightCycleInGraphUsingBellmanFord(nVertex, edgeList, src)){
			System.out.println("Negative Weight Cycle Exists");
		}
		else{
			System.out.println("No Negative Weight Cycle");
		}
	}

}