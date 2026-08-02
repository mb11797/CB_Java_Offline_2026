import java.util.*;

/*
9
7
0 1 
0 2 
2 3
4 5
5 6
7 8
1 3
*/

/*
9
5
0 1 
2 3
4 5
5 6
7 8
*/
public class ConnectedComponentsUsingDSU{

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
		// Path Compression
		return parent[node] = find(parent[node], parent);
	}

	public static void union(int u, int v, int[] parent){
		int leaderOfU = find(u, parent);
		int leaderOfV = find(v, parent);

		if(leaderOfU != leaderOfV){
			parent[leaderOfV] = leaderOfU;
		}
	}

	public static void unionByRank(int u, int v, int[] parent, int[] rank){
		int leaderOfU = find(u, parent);
		int leaderOfV = find(v, parent);

		if(leaderOfU != leaderOfV){
			if(rank[leaderOfU] >= rank[leaderOfV]){
				parent[leaderOfV] = leaderOfU;
				rank[leaderOfU] += rank[leaderOfV];
			}
			else{
				parent[leaderOfU] = leaderOfV;
				rank[leaderOfV] += rank[leaderOfU];
			}
		}
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int nVertex = scanner.nextInt();
		int[] parent = new int[nVertex];
		int[] rank = new int[nVertex];
		for(int i=0; i<parent.length; i++){
			parent[i] = i;
			rank[i] = 1;
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
			unionByRank(edge.u, edge.v, parent, rank);
		}

		Set<Integer> set = new HashSet<>();
		int connectedComponents = 0;
		System.out.println("Parent Array: ");
		for(int i=0; i<nVertex; i++){
			set.add(parent[i]);
			System.out.println(i + " -> " + parent[i]);
		}
		System.out.println();

		System.out.println("Rank Array: ");
		for(int i=0; i<nVertex; i++){
			System.out.println(i + " -> " + rank[i]);
		}
		System.out.println();

		System.out.println("Total Connected Components: " + set.size());
	}
}