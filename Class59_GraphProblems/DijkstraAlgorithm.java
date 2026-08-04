import java.util.*;
import java.io.*;

/*
Enter no of Vertex: 
7

Enter no of Edges: 
8

Enter Edges Info: 
0 1 10 true
0 2 40 true
1 3 10 true
2 3 10 true
2 4 25 true
4 5 10 true
5 6 10 true
4 6 30 true

Enter src Vertex: 
0
*/


public class DijkstraAlgorithm{

	public static class Edge{
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

	public static class NodePathCostTriplet implements Comparable<NodePathCostTriplet>{
		int node;
		String path;
		int cost;
		public NodePathCostTriplet(int node, String path, int cost){
			this.node = node;
			this.path = path;
			this.cost = cost;
		}

		@Override
		public int compareTo(NodePathCostTriplet other){
			// this vs other
			// M-1:
			// return this.cost - other.cost;
			// M-2:
			return Integer.compare(this.cost, other.cost);
		}
	}

	public static class MyTripletComparator implements Comparator<NodePathCostTriplet>{
		@Override
		public int compare(NodePathCostTriplet a, NodePathCostTriplet b){
			return a.cost - b.cost;
		}
	}

	public static void ssspDijkstraAlgorithm(List<Pair>[] adjListGraph, int src){
		int nVertex = adjListGraph.length;

		// M-1: Comparator Way:
		// PriorityQueue<NodePathCostTriplet> minPq = new PriorityQueue<>(new MyTripletComparator());
		// M-2: Comparable Way:
		PriorityQueue<NodePathCostTriplet> minPq = new PriorityQueue<>();
		boolean[] visited = new boolean[nVertex];
		minPq.offer(new NodePathCostTriplet(src, src+"", 0));

		while(!minPq.isEmpty()){
			NodePathCostTriplet top = minPq.poll();
			int curNode = top.node;
			String curPath = top.path;
			int curCost = top.cost;

			if(visited[curNode]){
				continue;
			}

			visited[curNode] = true;

			System.out.println(src + " to " + curNode + " via Path => " + curPath + " | cost = " + curCost);

			for(Pair nbr: adjListGraph[curNode]){
				if(!visited[nbr.node]){
					minPq.offer(new NodePathCostTriplet(nbr.node, curPath + nbr.node, curCost + nbr.wt));
				}
			}
		}
		return;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter no of Vertex: ");
		int nVertex = Integer.parseInt(br.readLine());
		System.out.println("Enter no of Edges: ");
		int nEdges = Integer.parseInt(br.readLine());

		/*
		5
		3
		0 1 10 true
		0 2 40 				<- by default bidirectional = true -> undirected edge
		...
		*/

		System.out.println("Enter Edges Info: ");
		List<Edge> edgeList = new ArrayList<>();	
		for(int i=0; i<nEdges; i++){
			String inputLine = br.readLine();
			String[] parts = inputLine.split(" ");		// "0", "1", "10", "true"
			int u = Integer.parseInt(parts[0]);			// parts[0] = "0"
			int v = Integer.parseInt(parts[1]);			// parts[1] = "1"
			int wt = Integer.parseInt(parts[2]);		// parts[2] = "10"
			boolean isBidirectional;
			if(parts.length > 3){
				isBidirectional = parts[3].equals("true") ? true : false;
			}
			else{
				isBidirectional = true;
			}
			edgeList.add(new Edge(u, v, wt, isBidirectional));
		}

		System.out.println("Enter src Vertex: ");
		int src = Integer.parseInt(br.readLine());

		List<Pair>[] adjListGraph = buildGraph(nVertex, edgeList);
		printGraph(adjListGraph);

		System.out.println("Calling ssspDijkstraAlgorithm():");
		// call Dijkstra Algo to print minimum Cost Path to All Nodes in Graph from given source vertex
		ssspDijkstraAlgorithm(adjListGraph, src);
	}
}