import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        // Please write your code here.
        Deque<Integer> dp = new ArrayDeque<>();

        for (int i = 0; i < n ; i++){
            String command = sc.nextLine();
            if (command.startsWith("push_front")){
                String[] parts = command.split(" ");
                int value = Integer.parseInt(parts[1]);
                dp.addFirst(value);
            }
            else if (command.startsWith("push_back")){
                String[] parts = command.split(" ");
                int value = Integer.parseInt(parts[1]);
                dp.addLast(value);
            }
            else if (command.startsWith("pop_front")){
                System.out.println(dp.pollFirst());
            }
            else if (command.startsWith("pop_back")){
                System.out.println(dp.pollLast());
            }
            else if (command.equals("empty")){
                System.out.println(dp.isEmpty() ? 1 : 0);
            }
            else if (command.equals("size")){
                System.out.println(dp.size());
            }
            else if (command.equals("front")){
                System.out.println(dp.peekFirst());
            }
            else if (command.equals("back")){
                System.out.println(dp.peekLast());
            }
            
        }
    }
}