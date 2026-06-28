public class LinkedListStackDemo{
	public static void main(String[] args){
		Stack<Integer> stk = new LinkedListStack<>();
		stk.push(3);
		System.out.println("Peek: " + stk.peek() + " | Size = " + stk.size());
		stk.push(1);
		System.out.println("Peek: " + stk.peek() + " | Size = " + stk.size());
		stk.push(2);
		System.out.println("Peek: " + stk.peek() + " | Size = " + stk.size());
		stk.push(6);
		System.out.println("Peek: " + stk.peek() + " | Size = " + stk.size());
		stk.push(8);
		System.out.println("Peek: " + stk.peek() + " | Size = " + stk.size());
		stk.push(4);
		System.out.println("Peek: " + stk.peek() + " | Size = " + stk.size());
		stk.push(11);
		System.out.println("Peek: " + stk.peek() + " | Size = " + stk.size());


		int poppedEl = stk.pop();
		System.out.println("Popped Element: " + poppedEl);
		System.out.println("Peek: " + stk.peek() + " | Size = " + stk.size());

		stk.pop();
		System.out.println("Peek: " + stk.peek() + " | Size = " + stk.size());
		stk.pop();
		stk.pop();
		stk.pop();
		stk.pop();
		stk.pop();
		stk.pop();
		stk.pop();
		stk.pop();
		stk.pop();
		stk.pop();
		stk.pop();
	}	
}