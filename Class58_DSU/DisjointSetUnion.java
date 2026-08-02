import java.util.*;

public class DisjointSetUnion{

	public static class Edge{
		int u;
		int v;
		public Edge(int u, int v){
			this.u = u;
			this.v = v;
		}
	}

	public static int find(int node, int[] parent){
		if(parent[node] == node){
			return node;
		}
		return find(parent[node], parent);
	}

	/*
	M-2: Iterative
	public static int find(int node, int[] parent){
		while(parent[node] != node){
			node = parent[node];
		}
		return node;
	}
	*/

	public static void union(int u, int v, int[] parent){
		int leaderOfU = find(u, parent);
		int leaderOfV = find(v, parent);

		if(leaderOfU != leaderOfV){
			parent[leaderOfU] = leaderOfV;
			// or:
			// parent[leaderOfV] = leaderOfU;
		}
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int nVertex = scanner.nextInt();
		int[] parent = new int[nVertex];
		for(int i=0; i<parent.length; i++){
			parent[i] = i;
		}

		List<Edge> edgeList = new ArrayList<>();
		int nEdges = scanner.nextInt();
		for(int i=0; i<nEdges; i++){
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			edgeList.add(new Edge(u, v));
		}

		for(Edge edge: edgeList){
			// edge : u - v
			int leaderOfU = find(edge.u, parent);
			int leaderOfV = find(edge.v, parent);
			union(edge.u, edge.v, parent);
		}

		for(int i=0; i<nVertex; i++){
			System.out.println(i + " -> " + parent[i]);
		}
	}
}