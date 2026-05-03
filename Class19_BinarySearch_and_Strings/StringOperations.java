import java.util.Scanner;

class StringOperations {

    public static String reverse(String str) {
        int i = str.length()-1;
        String reversed = "";                       // String -> immutable

        while(i >= 0){
            reversed += str.charAt(i--);
        }

        return reversed;
    }

    public static String reverseEfficient(String str) {
        int i = str.length()-1;
        StringBuilder sb = new StringBuilder();     // StringBuilder -> mutable

        while(i >= 0){
            sb.append(str.charAt(i--));
        }

        return sb.toString();
    }

    public static boolean palindrome(String str){
        int beg = 0, en = str.length() - 1;
        while(beg <= en){
            if(str.charAt(beg) != str.charAt(en)){
                return false;
            }
            beg++;
            en--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        System.out.println(reverse(str));  
        System.out.println(reverseEfficient(str));   

        if(palindrome(str)){
            System.out.println(str + " is Palindrome");
        }     
        else{
            System.out.println(str + " is not a Palindrome");
        }
    }
}