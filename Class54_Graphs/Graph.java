import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Graph{

	public static void printGraph(List<Integer>[] graph){
		int nVertex = graph.length;
		for(int i=0; i<nVertex; i++){
			System.out.print("Vertex " + i + " -> ");
			for(int nbr: graph[i]){
				System.out.print(nbr + ", ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int nVertex = scanner.nextInt();
		List<Integer>[] graph = new ArrayList[nVertex];
		// List<List<Integer>> graph = new ArrayList<>();

		for(int i=0; i<nVertex; i++){
			graph[i] = new ArrayList<>();
			int nbr = scanner.nextInt();
			while(nbr != -1){
				graph[i].add(nbr);
				nbr = scanner.nextInt();
			}
		}

		printGraph(graph);
	}

}

