import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        // Please write your code here.
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            String command = sc.nextLine();
            if (command.startsWith("push")){
                String[] parts = command.split(" ");
                int value = Integer.parseInt(parts[1]);
                q.add(value);
            }
            else if (command.equals("pop")){
                System.out.println(q.poll());
            }
            else if (command.equals("size")){
                System.out.println(q.size());
            }
            else if (command.equals("front")){
                System.out.println(q.peek());
            }
            else if (command.equals("empty")){
                 System.out.println(q.isEmpty() ? 1 : 0);
            }
        }
    }
}