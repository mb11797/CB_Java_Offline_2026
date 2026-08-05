import java.util.*;

public class LanCableNetworkPrimsAlgorithmMST{

	public static class Pair{
		String node;
		int wt;
		public Pair(String node, int wt){
			this.node = node;
			this.wt = wt;
		}
	}

	public static void addEdge(Map<String, List<Pair>> adjListGraph, String u, String v, int wt, boolean isBidirectional){
		List<Pair> nbrsOfU = adjListGraph.getOrDefault(u, new ArrayList<>());
		nbrsOfU.add(new Pair(v, wt));
		adjListGraph.put(u, nbrsOfU);
		if(isBidirectional){
			List<Pair> nbrsOfV = adjListGraph.getOrDefault(v, new ArrayList<>());
			nbrsOfV.add(new Pair(u, wt));
			adjListGraph.put(v, nbrsOfV);			
		}
	}

	public static void printGraph(Map<String, List<Pair>> adjListGraph){
		System.out.println("Printing Graph: ");
		for(Map.Entry<String, List<Pair>> entry: adjListGraph.entrySet()){
			System.out.print(entry.getKey() + " -> ");
			for(Pair nbrPr: entry.getValue()){
				System.out.print("(" + nbrPr.node + ", " + nbrPr.wt + "), ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static class PrimsTriplet implements Comparable<PrimsTriplet>{
		String vtx;
		String aqVtx;	// aquiring / referring vertex
		int wt;			// cost
		public PrimsTriplet(String v, String aV, int wt){
			vtx = v;
			aqVtx = aV;
			this.wt = wt;
		}

		@Override
		public int compareTo(PrimsTriplet other){
			// this vs other
			return this.wt - other.wt;
		}
	}

	public static int minCostToConnectAllCities_MST_usingPrimsAlgo(Map<String, List<Pair>> adjListGraph){
		PriorityQueue<PrimsTriplet> minPQ = new PriorityQueue<>();

		minPQ.offer(new PrimsTriplet("Agra", "$", 0));

		Set<String> visitedSet = new HashSet<>();

		int totCost = 0;
		while(!minPQ.isEmpty()){
			PrimsTriplet top = minPQ.poll();
			String curVtx = top.vtx;
			String curAqVtx = top.aqVtx;
			int curWt = top.wt;

			// check if curVtx is already visited
			if(visitedSet.contains(curVtx)){
				continue;
			}

			visitedSet.add(curVtx);

			if(!curAqVtx.equals("$")){
				System.out.println(curVtx + " visited via " + curAqVtx + " with cost = " + curWt);
			}

			totCost += curWt;

			List<Pair> nbrs = adjListGraph.getOrDefault(curVtx, new ArrayList<>());
			for(Pair nbrPr: nbrs){
				String nbrNode = nbrPr.node;
				int curNbrWt = nbrPr.wt;
				// nbrPr -> {node, wt}
				if(!visitedSet.contains(nbrNode)){
					minPQ.offer(new PrimsTriplet(nbrNode, curVtx, curNbrWt));
				}
			}
		}

		return totCost;
	}

	public static void main(String[] args){
		Map<String, List<Pair>> adjListGraph = new HashMap<>();		// node -> list<nbr>

		addEdge(adjListGraph, "Delhi", "Lansdowne", 35, true);		// true -> bidirectional -> undirected edge
		addEdge(adjListGraph, "Delhi", "Agra", 10, true);		// true -> bidirectional -> undirected edge
		addEdge(adjListGraph, "Delhi", "Goa", 40, true);		// true -> bidirectional -> undirected edge
		addEdge(adjListGraph, "Delhi", "Hyderabad", 30, true);		// true -> bidirectional -> undirected edge
		addEdge(adjListGraph, "Goa", "Lucknow", 30, true);		// true -> bidirectional -> undirected edge
		addEdge(adjListGraph, "Agra", "Lucknow", 5, true);		// true -> bidirectional -> undirected edge
		addEdge(adjListGraph, "Goa", "Pune", 20, true);		// true -> bidirectional -> undirected edge
		addEdge(adjListGraph, "Pune", "Hyderabad", 15, true);		// true -> bidirectional -> undirected edge
		addEdge(adjListGraph, "Lucknow", "Lansdowne", 25, true);		// true -> bidirectional -> undirected edge

		printGraph(adjListGraph);

		int minCost = minCostToConnectAllCities_MST_usingPrimsAlgo(adjListGraph);
		System.out.println("Cost of MST = " + minCost);
	}
}