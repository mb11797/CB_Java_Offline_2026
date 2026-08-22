import java.util.*;

public class TrieDemo{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter total no of words: ");
		int n = scanner.nextInt();
		String[] words = new String[n];

		Trie trie = new Trie();
		System.out.println("Input all words: ");
		for(int i=0; i<n; i++){
			words[i] = scanner.next();
			trie.insert(words[i]);
		}

		System.out.println("Enter word to search: ");
		String word = scanner.next();
		System.out.println("Searching Word = " + word + "...");
		if(trie.search(word)){
			System.out.println(word + " found");
		}
		else{
			System.out.println(word + " not found");		
		}

		System.out.println("Enter prefix to search: ");
		String prefix = scanner.next();
		System.out.println("Searching Prefix = " + prefix + "...");
		if(trie.searchPrefix(prefix)){
			System.out.println("Found words with given prefix = " + prefix);
		}
		else{
			System.out.println("Not words found with given prefix = " + prefix);
		}

		List<String> ans = trie.searchAllWordsWithGivenPrefix(prefix);
		System.out.println("All words found with given prefix = " + prefix + " are as below: ");
		for(String s: ans){
			System.out.print(s + " ");
		}
	}
}