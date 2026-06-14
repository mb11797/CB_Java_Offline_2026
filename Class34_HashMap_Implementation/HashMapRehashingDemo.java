import java.util.Random;

public class HashMapRehashingDemo{
	public static void main(String[] args){
		Map<Integer, Integer> m = new HashMap<>();
		Random random = new Random();
        
        // Generates a random number from 0 to 9
        
		for(int i=0; i<100; i++){
			int key = random.nextInt(200); 
			int val = random.nextInt(500); 
			m.put(key, val);
		}
		
	}
}