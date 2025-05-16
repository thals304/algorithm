import java.util.Scanner;
import java.util.Stack;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        // Please write your code here.
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < n; i++){
            String command = sc.nextLine();
            if (command.startsWith("push")){
                String[] parts = command.split(" ");
                int value = Integer.parseInt(parts[1]);
                s.push(value);
            }
            else if (command.equals("size")){
                System.out.println(s.size());
            }
            else if (command.equals("pop")){
                System.out.println(s.pop());
            }
            else if (command.equals("empty")){
                System.out.println(s.isEmpty() ? 1 : 0);
            }
            else if (command.equals("top")){
                if (!s.isEmpty()){
                    System.out.println(s.peek());
                }
            }
        }

    }
}