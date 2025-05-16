import java.util.Scanner;
import java.util.Stack;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        // Please write your code here.
        Stack<String> s = new Stack<>();
        for(int x : str.toCharArray()){
            if (x == '(')
                s.push("(");
            else if (x == ')'){
                if (!s.isEmpty()){
                    s.pop();
                }
            }
        }

        if (!s.isEmpty()){
            System.out.println("No");
        }
        else {
            System.out.println("Yes");
        }

    }
}