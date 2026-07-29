import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/*
Enter nVertex: 
11

Enter all the city names: 
Mumbai
Delhi
Mizoram
Kerala
Assam
Lansdowne
PortBlair
Rangat
Kavaratti
Agatti
LoneCity

Enter nEdges: 
9

Enter Edges Data (line by line): 
Mumbai Mizoram true
Mumbai Delhi true
Delhi Assam true
Assam Lansdowne true
Assam Kerala true
Assam Mizoram true
Kerala Mizoram true
PortBlair Rangat true
Kavaratti Agatti true
*/


public class ConnectedComponentsInGraph{

	public static class Edge{
		String u;
		String v;
		boolean isBidirectional;

		public Edge(String u, String v, boolean isBidirectional){
			this.u = u;
			this.v = v;
			this.isBidirectional = isBidirectional;
		}
	}

	private static void buildGraph(int nVertex, List<Edge> edgeList, Map<String, List<String>> adjListGraph){
		for(Edge edge: edgeList){
			String u = edge.u;
			String v = edge.v;
			boolean isBidirectional = edge.isBidirectional;
			List<String> nbrsOfU = adjListGraph.getOrDefault(u, new ArrayList<>());
			nbrsOfU.add(v);
			adjListGraph.put(u, nbrsOfU);
			if(isBidirectional){
				List<String> nbrsOfV = adjListGraph.getOrDefault(v, new ArrayList<>());
				nbrsOfV.add(u);
				adjListGraph.put(v, nbrsOfV);
			}
		}

		return;
	}

	public static void printGraph(Map<String, List<String>> graph){
		System.out.println("Graph (Adjacency List Representation): ");
		for(Map.Entry<String, List<String>> entry: graph.entrySet()){
			System.out.print(entry.getKey() + " -> ");
			for(String nbr: entry.getValue()){
				System.out.print(nbr + ", ");
			}
			System.out.println();
		}
		System.out.println();
		return;
	}

	public static void bfs(Map<String, List<String>> adjListGraph, String src, int nVertex, Map<String, Boolean> visitedMap){
		Queue<String> q = new LinkedList<>();
		q.offer(src);

		while(!q.isEmpty()){
			String front = q.poll();

			if(visitedMap.containsKey(front)){
				continue;
			}

			// print
			System.out.print(front + " ");

			// mark visited
			visitedMap.put(front, true);

			// explore neighbours
			List<String> nbrs = adjListGraph.getOrDefault(front, new ArrayList<>());
			for(String nbr: nbrs){
				if(!visitedMap.containsKey(nbr)){
					q.offer(nbr);
				}
			}
		}
		return;
	}

	public static void main(String[] args) throws IOException{	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter nVertex: ");
		int nVertex = Integer.parseInt(br.readLine());		// br.readLine() -> throws IOException

		System.out.println("Enter all the city names: ");
		Map<String, List<String>> adjListGraph = new HashMap<>();
		for(int i=0; i<nVertex; i++){
			String city = br.readLine();
			adjListGraph.put(city, new ArrayList<>());
		}

		System.out.println("Enter nEdges: ");
		int nEdges = Integer.parseInt(br.readLine());

		System.out.println("Enter Edges Data (line by line): ");
		List<Edge> edgeList = new ArrayList<>();
		for(int i=0; i<nEdges; i++){
			String inputEdgeData = br.readLine();	
			// inputEdgeData = "Mumbai Delhi false"
			// inputEdgeData = "Mumbai Delhi"
			String[] parts = inputEdgeData.split(" ");	
			// parts[0] = "2", parts[1] = "3", parts[2] = "false"
			String u = parts[0];		// u = "Mumbai"
			String v = parts[1];		// v = "Delhi"
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
		System.out.println();

		buildGraph(nVertex, edgeList, adjListGraph);

		printGraph(adjListGraph);

		Map<String, Boolean> visitedMap = new HashMap<>();
		System.out.println("BFS Traversal of Graph: ");
		for(String city: adjListGraph.keySet()){
			if(!visitedMap.containsKey(city)){
				bfs(adjListGraph, city, nVertex, visitedMap);
			}
		}
		System.out.println();
		return;
	}
}