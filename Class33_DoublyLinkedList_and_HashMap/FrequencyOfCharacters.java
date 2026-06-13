import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class FrequencyOfCharacters{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		Map<Character, Integer> charFreqMap = new HashMap<>();
		
		for(int i=0; i<str.length(); i++){
			char ch = str.charAt(i);
			charFreqMap.put(ch, charFreqMap.getOrDefault(ch, 0) + 1);
		}

		for(Map.Entry<Character, Integer> entry: charFreqMap.entrySet()){
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
		return;
	}
}