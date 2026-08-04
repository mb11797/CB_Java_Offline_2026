import java.util.*;

public class TopologicalSortUsingDFS{

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

	public static void printVisitedMap(Map<String, Boolean> visitedMap){
		System.out.println("Printing Visited Map: ");
		for(Map.Entry<String, Boolean> entry: visitedMap.entrySet()){
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
		System.out.println();
	}

	public static void topologicalSortUsingDFSHelper(Map<String, List<String>> adjListGraph, 
		String node, Stack<String> stk, Map<String, Boolean> visitedMap){

		visitedMap.put(node, true);

		for(String nbr: adjListGraph.getOrDefault(node, new ArrayList<>())){
			if(visitedMap.get(nbr) == false){
				topologicalSortUsingDFSHelper(adjListGraph, nbr, stk, visitedMap);
			}
		}

		stk.push(node);

		return;
	}

	public static List<String> topologicalSortUsingDFS(Map<String, List<String>> adjListGraph){
		Stack<String> stk = new Stack<>();

		Map<String, Boolean> visitedMap = new HashMap<>();

		for(Map.Entry<String, List<String>> entry: adjListGraph.entrySet()){
			visitedMap.put(entry.getKey(), false);
			for(String nbr: entry.getValue()){
				visitedMap.put(nbr, false);
			}
		}
		printVisitedMap(visitedMap);

		for(Map.Entry<String, Boolean> entry: visitedMap.entrySet()){
			if(visitedMap.get(entry.getKey()) == false){
				topologicalSortUsingDFSHelper(adjListGraph, entry.getKey(), stk, visitedMap);
			}
		}

		// Order of Execution of Tasks:
		List<String> topoSort = new ArrayList<>();
		while(!stk.isEmpty()){
			topoSort.add(stk.pop());
		}

		return topoSort;
	}


	public static void main(String[] args){
		// Directed Acyclic Graph
		Map<String, List<String>> adjListGraph = new HashMap<>();		// node -> list<nbr>

		// dependencies or prerequisites
		addEdge(adjListGraph, "Java", "WebApp", false);		
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

		List<String> topoSort = topologicalSortUsingDFS(adjListGraph);
		System.out.println("Topological Sort: ");
		for(String node: topoSort){
			System.out.print(node + " -> ");
		}
		System.out.println("End");

	}
}