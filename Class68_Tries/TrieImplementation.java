import java.util.*;

public class TrieImplementation{

	public static class TrieNode{
		char data;
		Map<Character, TrieNode> children;
		boolean isTerminal;

		public TrieNode(char data){
			this.data = data;
			this.children = new HashMap<>();
			this.isTerminal = false;
		}
	}

	insert


	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String[] words = new String[n];
		for(int i=0; i<n; i++){
			words[i] = scanner.next();
			insert();
		}


	}
}