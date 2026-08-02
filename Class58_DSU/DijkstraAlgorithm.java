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

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int nVertex = Integer.parseInt(br.readLine());
		int nEdges = Integer.parseInt(br.readLine());

		List<Edge> edgeList = new ArrayList<>();	
		for(int i=0; i<nEdges; i++){
			String inputLine = br.readLine();
			String[] parts = inputLine.split(" ");
			int u = Integer.parseInt(parts[0]);
			int v = Integer.parseInt(parts[1]);
			int wt = Integer.parseInt(parts[2]);
			boolean isBidirectional;
			if(parts.length > 3){
				isBidirectional = parts[3].equals("true") ? true : false;
			}
			else{
				isBidirectional = true;
			}
			edgeList.add(new Edge(u, v, wt, isBidirectional));
		}

		List<Pair>[] adjListGraph = buildGraph();

	}
}