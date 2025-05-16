import java.util.Scanner;
import java.util.Stack;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        // Please write your code here.
        Stack<Character> s = new Stack<>();
        for(char x : str.toCharArray()){
            if (x == '(')
                s.push(x);
            else if (x == ')'){
                if (s.isEmpty()){
                    System.out.println("No");
                    return;
                }
                s.pop();
            }
        }

        System.out.println(s.isEmpty() ? "Yes" : "No");

    }
}