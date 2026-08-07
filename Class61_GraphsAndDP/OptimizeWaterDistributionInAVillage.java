import java.util.*;
import java.io.*;

/*
Enter no of Houses: 
6
Enter Well(s) Creation Cost: 
30 2 50 60 10 2
Enter no of Pipes: 
8
Enter Pipes Info: 
3 1 40
3 2 30
3 6 10
2 6 5
1 6 50
2 4 25
2 5 20
5 4 30
*/

public class OptimizeWaterDistributionInAVillage{

	private static int[] parent;
	private static int[] rank;

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

	public static void printEdgeList(List<Edge> edgeList){
		System.out.println("Printing Edge List: ");
		for(Edge edge: edgeList){
			System.out.println(edge.u + ", " + edge.v + ", " + edge.wt);
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

	public static int find(int node){
		if(parent[node] == node){
			return node;
		}
		return parent[node] = find(parent[node]);
	}

	public static boolean unionByRank(int u, int v){
		int leaderOfU = find(u);
		int leaderOfV = find(v);

		if(leaderOfU != leaderOfV){
			// not a redundant edge
			// merging will occur
			if(rank[leaderOfU] > rank[leaderOfV]){
				parent[leaderOfV] = leaderOfU;
				rank[leaderOfU] += rank[leaderOfV];
			}
			else if(rank[leaderOfU] < rank[leaderOfV]){
				parent[leaderOfU] = leaderOfV;
				rank[leaderOfV] += rank[leaderOfU];
			}
			else{
				parent[leaderOfV] = leaderOfU;
				rank[leaderOfU] += rank[leaderOfV];
			}
			return true;
		}
		else{
			return false;
		}
	}	

	public static int findMstUsingKruskalsAlgorithm(int nVertex, List<Edge> edgeList){
		printEdgeList(edgeList);
		System.out.println("Sorting Edge List...");
		Collections.sort(edgeList);
		printEdgeList(edgeList);
		
		parent = new int[nVertex];
		rank = new int[nVertex];

		for(int i=0; i<nVertex; i++){
			parent[i] = i;
			rank[i] = 1;
		}

		System.out.println("Minimum Spanning Tree: ");
		int mstCost = 0;
		for(Edge edge: edgeList){
			if(unionByRank(edge.u, edge.v)){
				// merging took place -> means current edge is not redundant and should be part of MST
				if(edge.u == 0 || edge.v == 0)
					System.out.println(edge.u + ", " + edge.v + ", " + edge.wt + " -> well");
				else
					System.out.println(edge.u + ", " + edge.v + ", " + edge.wt);
				mstCost += edge.wt;
			}
		}

		return mstCost;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter no of Houses: ");
		int nHouses = Integer.parseInt(br.readLine());

		System.out.println("Enter Well(s) Creation Cost: ");
		int[] wells = new int[nHouses];
		String inputLineForWells = br.readLine();
		String[] partsForWells = inputLineForWells.split(" ");
		for(int i=0; i<nHouses; i++){
			wells[i] = Integer.parseInt(partsForWells[i]);
		}

		System.out.println("Enter no of Pipes: ");
		int nEdges = Integer.parseInt(br.readLine());

		System.out.println("Enter Pipes Info: ");
		List<Edge> pipeList = new ArrayList<>();	
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
			pipeList.add(new Edge(u, v, wt, isBidirectional));
		}

		// create pipes from dummyHouse to all other house using wells
		for(int i=0; i<wells.length; i++){
			pipeList.add(new Edge(0, i+1, wells[i], true));
		}

		List<Pair>[] adjListGraph = buildGraph(nHouses+1, pipeList);
		printGraph(adjListGraph);

		int mstCost = findMstUsingKruskalsAlgorithm(nHouses+1, pipeList);		// MST Cost
		System.out.println("MST Cost = " + mstCost);
	}



}