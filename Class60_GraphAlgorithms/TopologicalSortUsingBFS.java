import java.util.*;

public class TopologicalSortUsingBFS{

	public static void addEdge(Map<String, List<String>> adjListGraph, String u, String v, boolean isBidirectional){
		List<String> nbrsOfU = adjListGraph.getOrDefault(u, new ArrayList<>());
		nbrsOfU.add(v);
		adjListGraph.put(u, nbrsOfU);
		if(isBidirectional){
			List<String> nbrsOfV = adjListGraph.getOrDefault(v, new ArrayList<>());
			nbrsOfV.add(u);
			adjListGraph.put(v, nbrsOfV);			
		}
	}

	public static void printGraph(Map<String, List<String>> adjListGraph){
		System.out.println("Printing Graph: ");
		for(Map.Entry<String, List<String>> entry: adjListGraph.entrySet()){
			System.out.print(entry.getKey() + " -> ");
			for(String nbr: entry.getValue()){
				System.out.print(nbr + ", ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void printIndegreeMap(Map<String, Integer> indegreeMap){
		System.out.println("Indegree Map: ");
		for(Map.Entry<String, Integer> entry: indegreeMap.entrySet()){
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
		System.out.println();
	}

	public static List<String> topologicalSortUsingBFS(Map<String, List<String>> adjListGraph){
		// Step-1: Calculate Indegree of all Nodes
		Map<String, Integer> indegreeMap = new HashMap<>();

		for(Map.Entry<String, List<String>> entry: adjListGraph.entrySet()){
			String node = entry.getKey();
			List<String> nbrs = entry.getValue();

			if(!indegreeMap.containsKey(node)){
				indegreeMap.put(node, 0);
			}

			for(String nbr: nbrs){
				indegreeMap.put(nbr, indegreeMap.getOrDefault(nbr, 0) + 1);
			}
		}

		printIndegreeMap(indegreeMap);

		// Step-2: Insert nodes with indegree = 0 in Queue
		Queue<String> q = new LinkedList<>();
		for(Map.Entry<String, Integer> entry: indegreeMap.entrySet()){
			if(entry.getValue() == 0){
				q.offer(entry.getKey());
			}
		}

		// Step-3: Perform BFS and fill topoSort List
		List<String> topoSort = new ArrayList<>();
		while(!q.isEmpty()){
			String frontNode = q.poll();

			topoSort.add(frontNode);

			// Decrease indegree of all neighbours of frontNode by 1
			List<String> nbrs = adjListGraph.getOrDefault(frontNode, new ArrayList<>());
			for(String nbr: nbrs){
				indegreeMap.put(nbr, indegreeMap.get(nbr)-1);
				if(indegreeMap.get(nbr) == 0){
					q.offer(nbr);
				}
			}
		}

		return topoSort;
	}


	public static void main(String[] args){
		// Directed Acyclic Graph
		Map<String, List<String>> adjListGraph = new HashMap<>();		// node -> list<nbr>

		// dependencies or prerequisites
		addEdge(adjListGraph, "Java", "WebApp", false);		// false -> not bidirectional -> directed edge
		addEdge(adjListGraph, "Math", "DSA", false);		
		addEdge(adjListGraph, "DSA", "Python", false);		
		addEdge(adjListGraph, "English", "HTML", false);	
		addEdge(adjListGraph, "English", "DSA", false);		
		addEdge(adjListGraph, "CSS", "JavaScript", false);		
		addEdge(adjListGraph, "HTML", "JavaScript", false);		
		addEdge(adjListGraph, "React", "WebApp", false);		
		addEdge(adjListGraph, "JavaScript", "React", false);		
		addEdge(adjListGraph, "Python", "WebApp", false);
		addEdge(adjListGraph, "DSA", "React", false);
		addEdge(adjListGraph, "DSA", "Java", false);
		addEdge(adjListGraph, "HTML", "CSS", false);

		printGraph(adjListGraph);


		List<String> topoSort = topologicalSortUsingBFS(adjListGraph);
		System.out.println("Topological Sort: ");
		for(String node: topoSort){
			System.out.print(node + " -> ");
		}
		System.out.println("End");

	}
}