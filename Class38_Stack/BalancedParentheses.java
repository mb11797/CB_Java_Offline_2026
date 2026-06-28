import java.util.Scanner;
import java.util.Stack;

public class BalancedParentheses{

	public static boolean isValidParentheses(String s) {
        Stack<Character> stk = new Stack<>();

        for(int i=0; i<s.length(); i++){
        	char ch = s.charAt(i);

        	if(ch == '('){
        		stk.push(ch);
        	}
        	else{
        		if(stk.isEmpty())
        			return false;

        		stk.pop();
        	}
        }

        return stk.isEmpty();
    }

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		String expression = scanner.next();			// ( , )

		if(isValidParentheses(expression)){
			System.out.println("Balanced");
		}
		else{
			System.out.println("Not Balanced");
		}
	}
}