import java.util.*;

public class Trie{

	public class TrieNode{
		char data;
		Map<Character, TrieNode> children;
		boolean isTerminal;

		public TrieNode(char data){
			this.data = data;
			this.children = new HashMap<>();
			this.isTerminal = false;
		}
	}

	TrieNode root;

	public Trie(){
		root = new TrieNode('\0');
	}

	public void insert(String word){

		TrieNode temp = root;

		for(int i=0; i<word.length(); i++){
			char ch = word.charAt(i);

			if(!temp.children.containsKey(ch)){
				// character not present -> put
				TrieNode newNode = new TrieNode(ch);
				temp.children.put(ch, newNode);
			}

			temp = temp.children.get(ch);
		}

		temp.isTerminal = true;
		return;
	}

	public boolean search(String word){
		// complete word search

		TrieNode temp = root;
		for(char ch: word.toCharArray()){

			if(!temp.children.containsKey(ch)){
				return false;
			}

			temp = temp.children.get(ch);
		}

		return temp.isTerminal;
	}


	public boolean searchPrefix(String prefix){
		// complete word search

		TrieNode temp = root;
		for(char ch: prefix.toCharArray()){

			if(!temp.children.containsKey(ch)){
				return false;
			}

			temp = temp.children.get(ch);
		}

		return true;
	}

	public List<String> searchAllWordsWithGivenPrefix(String prefix){
		// complete word search

		List<String> ans = new ArrayList<>();

		TrieNode temp = root;
		for(char ch: prefix.toCharArray()){

			if(!temp.children.containsKey(ch)){
				return ans;
			}

			temp = temp.children.get(ch);
		}

		StringBuilder prefixSB = new StringBuilder(prefix);
		dfs(temp, ans, prefixSB);
		return ans;
	}


	private void dfs(TrieNode node, List<String> ans, StringBuilder prefixSB){
		if(node.isTerminal == true){
			// prefixSB.append(node.data);
			ans.add(prefixSB.toString());
		}

		System.out.println("data: " + node.data);

		// if(node.isTerminal && node.children.size() == 0){
		// 	return 
		// }

		for(Map.Entry<Character, TrieNode> entry: node.children.entrySet()){
			prefixSB.append(entry.getKey());
			dfs(entry.getValue(), ans, prefixSB);
			prefixSB.deleteCharAt(prefixSB.length()-1);
		}
	}
}