import java.util.*;

public class AdjacencyListGraphUsingEdges{
	
	public static class Edge{
		int u;
		int v;

		public Edge(int u, int v){
			this.u = u;
			this.v = v;
		}
	}

	public static List<List<Integer>> buildGraph(List<Edge> edgeList, int nVertex){
		List<List<Integer>> adjList = new ArrayList<>();

		for(int i=0; i<nVertex; i++){
			adjList.add(new ArrayList<>());
		}

		for(Edge edge: edgeList){
			int u = edge.u;
			int v = edge.v;
			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}
		return adjList;
	}

	public static void printGraph(List<List<Integer>> graph){
		System.out.println("Graph (Adjacency List Representation): ");
		for(int i=0; i<graph.size(); i++){
			List<Integer> nbrs = graph.get(i);
			System.out.print("Vertex " + i + " -> ");
			for(int nbr: nbrs){
				System.out.print(nbr + ", ");
			}
			System.out.println();
		}
		System.out.println();
		return;
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int nVertex = scanner.nextInt();
		int nEdges = scanner.nextInt();


		List<Edge> edgeList = new ArrayList<>();
		for(int i=0; i<nEdges; i++){
			int u = scanner.nextInt();
			int v = scanner.nextInt();
			Edge edge = new Edge(u, v);
			edgeList.add(edge);
		}

		List<List<Integer>> adjListGraph = buildGraph(edgeList, nVertex);

		printGraph(adjListGraph);
	}
}