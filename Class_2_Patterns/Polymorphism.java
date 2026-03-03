public class Polymorphism{

	public static void KeshavEats(){
		System.out.println("Keshav can Eat");
	}

	public static void KeshavEats(String fruit){
		System.out.println("Keshav Eats " + fruit);
	}

	public static void KeshavEats(String fruit, int n){
		System.out.println("Keshav Eats " + n + " " + fruit);
	}

	public static void main(String[] args){
		KeshavEats();
		KeshavEats("mango");
		KeshavEats("apples", 5);
	}
}